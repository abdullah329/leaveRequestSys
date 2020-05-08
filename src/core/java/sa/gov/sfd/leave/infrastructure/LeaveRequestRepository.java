/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leave.infrastructure;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import sa.gov.sfd.leave.core.leaverequest.*;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveRequestRepository implements LeaveRequestInterface {


    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    //************************* SELECT Operations **************************************************
    @Override
    public List<LeaveRequestEntity> findAllLeaveRequest() {
        return  jdbcTemplate.query("" +
                        "SELECT * " +
                        "FROM leaveRequest r, LeaveDeductionDetails d " +
                        "WHERE r.leaveId = d.leaveId_fk",
                new LeaveRequestTrackerMapper());
    }

    @Override
    public List<LeaveRequestEntity> findAllLeaveRequestByEmployeeNID(EmployeeNID empNid) {
        return  jdbcTemplate.query("" +
                        "SELECT *" +
                        "FROM leaveRequest r, LeaveDeductionDetails d " +
                        "WHERE r.leaveId = d.leaveId_fk and EmployeeNID = ? ",
                new LeaveRequestTrackerMapper(),empNid.getId());
    }

    @Override
    public List<LeaveRequestEntity> findAllLeaveRequestNOTDeclinedByEmployeeNID(EmployeeNID empNid) {
        return  jdbcTemplate.query("" +
                        "SELECT *" +
                        "FROM leaveRequest r, LeaveDeductionDetails d " +
                        "WHERE r.leaveId = d.leaveId_fk and EmployeeNID = ? and requestStatus<>'D' ",
                new LeaveRequestTrackerMapper(),empNid.getId());
    }

    @Override
    public List<LeaveRequestEntity> findAllLeaveRequestPendingByEmployeeNID(EmployeeNID empNid) {
        return  jdbcTemplate.query("" +
                        "SELECT *" +
                        "FROM leaveRequest r, LeaveDeductionDetails d " +
                        "WHERE r.leaveId = d.leaveId_fk and EmployeeNID = ? and requestStatus='P' ",
                new LeaveRequestTrackerMapper(),empNid.getId());
    }

    @Override
    public List<LeaveRequestEntity> findOneLeaveRequestByRequestId(LeaveId leaveRequestId) {
        return jdbcTemplate.query("" +
                        "SELECT * " +
                        "FROM leaveRequest r, LeaveDeductionDetails d " +
                        "WHERE leaveRequestId = ? and r.leaveId = d.leaveId_fk ",
                new LeaveRequestTrackerMapper(),leaveRequestId.getId());
    }

    @Override
    public List<LeaveRequestDeductionDetails> findLeaveDeductionDetailsByRequestId(LeaveId leaveRequestId) {
        return  (List<LeaveRequestDeductionDetails>) jdbcTemplate.queryForObject("" +
                        "SELECT deductionYears,deductionNumberOfDays " +
                        "FROM LeaveRequestDeductionDetails " +
                        "WHERE LeavetId_fk = ? ",
                new BeanPropertyRowMapper<>(LeaveRequestDeductionDetails.class),leaveRequestId.getId());
    }




    //************************* UPDATE Operations **************************************************

    @Override
    public int updateLeaveStatus(LeaveId leaveRequestId, LeaveRequestStatus newStatus){
        return jdbcTemplate.update("" +
                        "UPDATE leaveRequest " +
                        "SET leaveRequestStatus = ? " +
                        "WHERE trasactionId =? " ,
                newStatus.toString(),
                leaveRequestId);
    }



    //************************* INSERT Operations **************************************************
    @Override
    public long insertNew(LeaveRequestInfo leaveInfo, LeaveRequestStatus requestStatus) {
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

    @Override
    public long insertNewLeaveDeductionDetails(LeaveRequestDeductionDetails leaveDeductionInfo, LeaveId leavetId) {
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
