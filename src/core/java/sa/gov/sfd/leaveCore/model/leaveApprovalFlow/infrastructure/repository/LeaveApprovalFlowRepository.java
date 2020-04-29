/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveApprovalFlow.infrastructure.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.LeaveApprovalProcessesFlowEntity;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.*;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeEntity;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.LeaveId;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author abdullahalgarni on 15/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveApprovalFlowRepository {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;


    public List<LeaveApprovalTransactionEntity> findByLeaveRequestId(LeaveId leaveRequestId) {
        return (List<LeaveApprovalTransactionEntity>) jdbcTemplate.queryForObject("" +
                        "SELECT * " +
                        "FROM LeaveApprovalTransaction " +
                        "WHERE leaveRequestId = ?",
                new BeanPropertyRowMapper<>(LeaveApprovalTransactionEntity.class), leaveRequestId.getId());
    }

    public List<LeaveApprovalProcessesFlowEntity> loadLeaveProcessScenarioByEmployeeNID(EmployeeNID approverNID) {
        return (List<LeaveApprovalProcessesFlowEntity>) jdbcTemplate.queryForObject("" +
                        "SELECT l.processId,l.approvalScenarioId,l.processStepNumber,l.approverTeamId " +
                        "FROM LeaveApprovalProcesses l, employee e " +
                        "WHERE l.approvalScenarioId = e.approvalScenarioId ",
                new BeanPropertyRowMapper<>(LeaveApprovalTransactionEntity.class));
    }

    public LastApprovalTransactionLine findLastStepNumberByLeaveId(LeaveId leaveId) {
        return jdbcTemplate.queryForObject("" +
                        "SELECT t.leaveApprovalTransDate, t.leaveId , t.processId, p.approvalScenarioId, " +
                        "p.processStepNumber,p.approverTeamId, t.employeeNID " +
                        "FROM LeaveApprovalTransaction t,  LeaveApprovalProcesses p " +
                        "WHERE t.leaveId = ?" +
                        "and p.processStepNumber =( " +
                        "SELECT max(processStepNumber) " +
                        "FROM LeaveApprovalProcesses " +
                        "WHERE t.processId = p.processId_fk  )",
                new BeanPropertyRowMapper<>(LastApprovalTransactionLine.class),leaveId.Id);
    }
    public List<LeaveApprovalTransactionEntity> findPendingRequestByApproveNID(EmployeeNID approverNID) {
        return (List<LeaveApprovalTransactionEntity>) jdbcTemplate.queryForObject("" +
                        "SELECT * " +
                        "FROM LeaveApprovalTransaction lt inner join leaveApprovalProcess ap " +
                        "on lt.processId_fk= ap.processId inner join ApproverTeam rt on ap.approverTeamId = rt.approverTeamId " +
                        "WHERE employeeNID = ?",
                new BeanPropertyRowMapper<>(LeaveApprovalTransactionEntity.class), approverNID.getId());
    }
    public List<Integer> findAllapproverTeamListByApproverId(EmployeeNID pApproverNID) {
        return  jdbcTemplate.queryForList("" +
                        "SELECT aprroverTeamId " +
                        "FROM ApproverTeam " +
                        "WHERE employeeNID = ?",
                Integer.class,pApproverNID.getId());
    }






    public List<EmployeeEntity> findAllEmplyee() {
        return (List<EmployeeEntity>) jdbcTemplate.queryForObject("" +
                        "SELECT * " +
                        "FROM employee ",
                new BeanPropertyRowMapper<>(EmployeeEntity.class));
    }




    //************************* UPDATE Operations **************************************************

    public int updateActionType(LeaveApprovalTransactionId transactionId, ApprovalActionTypes action){
        return jdbcTemplate.update("UPDATE LeaveApprovalTransaction " +
                        "SET leaveRequestAction = ? and actionTimeStamp = ?" +
                        "WHERE trasactionId =?" ,
                action.toString(),
                new Timestamp(System.currentTimeMillis())
        ); //leaveInfo.getLeaveRequestAction().toString(),
    }


    //************************* INSERT Operations **************************************************

    public int insertNewTransaction(LeaveApprovalTransactionEntity leaveInfo){
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
                leaveInfo.getLeaveApprovalTransDate().getLeaveAppTransDate_AH(),
                leaveInfo.getLeaveApprovalTransDate().getLeaveAppTransDate_AD(),
                leaveInfo.getLeaveRequestId(),
                leaveInfo.getProcessId(),
                leaveInfo.getapproverTeam().getEmployeeNID(),
                leaveInfo.getApprovalActionTypes().toString(),
                leaveInfo.getRequestTimeStamp()
                );
    }

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

