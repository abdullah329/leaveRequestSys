/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveRequest.infrastructure.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.LeaveRequestTrackerEntity;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.*;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveRequestRepository {


    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    //************************* SELECT Operations **************************************************
    public List<LeaveRequestTrackerEntity> findAllLeaveRequest() {
        return  jdbcTemplate.query("" +
                        "SELECT * " +
                        "FROM leaveRequest r, LeaveDeductionDetails d " +
                        "WHERE r.leaveId = d.leaveId_fk",
                new LeaveRequestTrackerMapper());
    }


    public List<LeaveRequestTrackerEntity> findAllLeaveRequestByEmployeeNID(EmployeeNID empNid) {
        return  jdbcTemplate.query("" +
                        "SELECT *" +
                        "FROM leaveRequest r, LeaveDeductionDetails d " +
                        "WHERE r.leaveId = d.leaveId_fk and EmployeeNID = ? ",
                new LeaveRequestTrackerMapper(),empNid.getId());
    }


    public List<LeaveRequestTrackerEntity> findAllLeaveRequestNOTDeclinedByEmployeeNID(EmployeeNID empNid) {
        return  jdbcTemplate.query("" +
                        "SELECT *" +
                        "FROM leaveRequest r, LeaveDeductionDetails d " +
                        "WHERE r.leaveId = d.leaveId_fk and EmployeeNID = ? and requestStatus<>'D' ",
                new LeaveRequestTrackerMapper(),empNid.getId());
    }



    public List<LeaveRequestTrackerEntity> findOneLeaveRequestByRequestId(LeaveId leaveRequestId) {
        return jdbcTemplate.query("" +
                        "SELECT * " +
                        "FROM leaveRequest r, LeaveDeductionDetails d " +
                        "WHERE leaveRequestId = ? and r.leaveId = d.leaveId_fk ",
                new LeaveRequestTrackerMapper(),leaveRequestId.getId());
    }


    public List<LeaveRequestDeductionDetails> findLeaveDeductionDetailsByRequestId(LeaveId leaveRequestId) {
        return  (List<LeaveRequestDeductionDetails>) jdbcTemplate.queryForObject("" +
                        "SELECT deductionYears,deductionNumberOfDays " +
                        "FROM LeaveRequestDeductionDetails " +
                        "WHERE LeavetId_fk = ? ",
                new BeanPropertyRowMapper<>(LeaveRequestDeductionDetails.class),leaveRequestId.getId());
    }




    //************************* UPDATE Operations **************************************************


    public int updateLeaveStatus(LeaveId leaveRequestId, LeaveRequestStatus newStatus){
        return jdbcTemplate.update("" +
                        "UPDATE leaveRequest " +
                        "SET leaveRequestStatus = ? " +
                        "WHERE trasactionId =? " ,
                newStatus.toString(),
                leaveRequestId);
    }



    //************************* INSERT Operations **************************************************

    public Long insertNew(LeaveRequestInfo leaveInfo,LeaveRequestStatus requestStatus) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        //parameters.put("leaveRequestId",leaveInfo.getEmployeeNID().getId());
        parameters.put("employeeNID",leaveInfo.getLeaveStartDate().getLeaveStartDate_AH());
        parameters.put("leaveStartDate_HD",leaveInfo.getLeaveStartDate().getLeaveStartDate_AD());
        parameters.put("leaveStartDate_AD",leaveInfo.getNumberOfDaysLeave());
        parameters.put("numberOfDaysLeave", leaveInfo.getNumberOfDaysLeave());
        parameters.put("requestStatus", requestStatus.getRequestStatus());

        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("leaveRequest")
                .usingGeneratedKeyColumns("leaveRequestId");

        return (Long) simpleJdbcInsert.executeAndReturnKey(parameters);


    }


    public int insertNewLeaveDeductionDetails(LeaveRequestDeductionDetails leaveDeductionInfo, LeaveId leavetId) {
        return jdbcTemplate.update("" +
                        "INSERT INTO LeaveRequestDeductionDetails " +
                        "(leaveDeductionId," +
                        "leaveRequestId, " +
                        "deductionYears," +
                        "deductionNumberOfDays) VALUES " +
                        "(leaveRequest_seq.nextval,?, ?, ?)",
                leavetId,
                leaveDeductionInfo.getDeductionYears(),
                leaveDeductionInfo.getDeductionNumberOfDays()

        );
    }


}
