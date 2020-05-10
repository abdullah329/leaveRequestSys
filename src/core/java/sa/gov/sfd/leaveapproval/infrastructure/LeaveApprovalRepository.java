/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveapproval.infrastructure;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sa.gov.sfd.leaveapproval.core.ApprovalProcessesEntity;
import sa.gov.sfd.leaveapproval.core.*;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import sa.gov.sfd.leaveapproval.core.EmployeeEntity;
import sa.gov.sfd.leave.core.leaverequest.LeaveId;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author abdullahalgarni on 15/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveApprovalRepository implements ApprovalInterface {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Override
    public List<ApprovalTransactionEntity> findByLeaveRequestId(LeaveId leaveRequestId) {
        return (List<ApprovalTransactionEntity>) jdbcTemplate.queryForObject("" +
                        "SELECT * " +
                        "FROM LeaveApprovalTransaction " +
                        "WHERE leaveRequestId = ?",
                new BeanPropertyRowMapper<>(ApprovalTransactionEntity.class), leaveRequestId.getId());
    }

    @Override
    public List<ApprovalProcessesEntity> loadLeaveProcessScenarioByEmployeeNID(EmployeeNID approverNID) {
        return (List<ApprovalProcessesEntity>) jdbcTemplate.queryForObject("" +
                        "SELECT l.processId,l.approvalScenarioId,l.processStepNumber,l.approverTeamId " +
                        "FROM LeaveApprovalProcesses l, employee e " +
                        "WHERE l.approvalScenarioId = e.approvalScenarioId ",
                new BeanPropertyRowMapper<>(ApprovalTransactionEntity.class));
    }

    @Override
    public CurrentApprovalTransactionLine findCurrentApprovalStepByLeaveId(LeaveId leaveId) {
        return jdbcTemplate.queryForObject("" +
                        "SELECT t.leaveApprovalTransDate, t.leaveId , t.processId, p.approvalScenarioId, " +
                        "p.processStepNumber,p.approverTeamId, t.employeeNID " +
                        "FROM LeaveApprovalTransaction t,  LeaveApprovalProcesses p " +
                        "WHERE t.leaveId = ?" +
                        "and p.processStepNumber =( " +
                        "SELECT max(processStepNumber) " +
                        "FROM LeaveApprovalProcesses " +
                        "WHERE t.processId = p.processId_fk  )",
                new BeanPropertyRowMapper<>(CurrentApprovalTransactionLine.class),leaveId.Id);
    }

    @Override
    public List<ApprovalTransactionEntity> findPendingRequestByApproveNID(EmployeeNID approverNID) {
        return (List<ApprovalTransactionEntity>) jdbcTemplate.queryForObject("" +
                        "SELECT * " +
                        "FROM LeaveApprovalTransaction lt inner join leaveApprovalProcess ap " +
                        "on lt.processId_fk= ap.processId inner join ApproverTeam rt on ap.approverTeamId = rt.approverTeamId " +
                        "WHERE employeeNID = ?",
                new BeanPropertyRowMapper<>(ApprovalTransactionEntity.class), approverNID.getId());
    }

    @Override
    public List<Integer> findAllapproverTeamListByApproverId(EmployeeNID pApproverNID) {
        return  jdbcTemplate.queryForList("" +
                        "SELECT aprroverTeamId " +
                        "FROM ApproverTeam " +
                        "WHERE employeeNID = ?",
                Integer.class,pApproverNID.getId());
    }

    @Override
    public List<EmployeeEntity> findAllEmplyee() {
        return (List<EmployeeEntity>) jdbcTemplate.queryForObject("" +
                        "SELECT * " +
                        "FROM employee ",
                new BeanPropertyRowMapper<>(EmployeeEntity.class));
    }




    //************************* UPDATE Operations **************************************************

    @Override
    public int updateActionType(ApprovalTransactionId transactionId, ApprovalActionTypes action){
        return jdbcTemplate.update("UPDATE LeaveApprovalTransaction " +
                        "SET leaveRequestAction = ? and actionTimeStamp = ?" +
                        "WHERE trasactionId =?" ,
                action.toString(),
                new Timestamp(System.currentTimeMillis())
        ); //leaveInfo.getLeaveRequestAction().toString(),
    }


    //************************* INSERT Operations **************************************************

    @Override
    public int insertNewTransaction(ApprovalTransactionEntity approvalTransInfo){

        return jdbcTemplate.update("INSERT INTO LeaveApprovalTransaction " +
                        "(trasactionId, " +
                        "leaveApprovalTransDate_AH, " +
                        "leaveApprovalTransDate_AD, " +
                        "leaveRequestId, " +
                        "processId, " +
                        "approverTeamId," +
                        "leaveRequestAction, " +
                        "requestTimeStamp " +
                        ") VALUES " +
                        "(LeaveApprovalTransaction_seq.nextval, ?, ?, ?, ?, ?, ?, ?)",
                approvalTransInfo.getLeaveApprovalTransDate().getLeaveAppTransDate_AH(),
                approvalTransInfo.getLeaveApprovalTransDate().getLeaveAppTransDate_AD(),
                approvalTransInfo.getLeaveRequestId(),
                approvalTransInfo.getProcessId(),
                approvalTransInfo.getApproverTeam().get(0).getApproverTeamId(),
                approvalTransInfo.getApprovalActionTypes().toString(),
                new Timestamp(System.currentTimeMillis())
                );
    }

    @Override
    public int insertNewEmployee(EmployeeEntity empInfo) {
        return jdbcTemplate.update("" +
                        "INSERT INTO employee " +
                        "(employeeNID, " +
                        "approvalDeptGroupId) VALUES " +
                        "(?, ?)",
                empInfo.getEmployeeNID().getId(),
                empInfo.getApprovalDeptGroupId().getId()
        );
    }
}

