/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leave.core.leaverequest;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import sa.gov.sfd.leave.infrastructure.LeaveRequestTrackerMapper;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/
public interface LeaveRequestInterface {

    //************************* SELECT Operations **************************************************
    List<LeaveRequestEntity> findAllLeaveRequest();


    List<LeaveRequestEntity> findAllLeaveRequestByEmployeeNID(EmployeeNID empNid);

    List<LeaveRequestEntity> findAllLeaveRequestNOTDeclinedByEmployeeNID(EmployeeNID empNid);

    List<LeaveRequestEntity> findAllLeaveRequestPendingByEmployeeNID(EmployeeNID empNid);

    List<LeaveRequestEntity> findOneLeaveRequestByRequestId(LeaveId leaveRequestId);

    List<LeaveRequestDeductionDetails> findLeaveDeductionDetailsByRequestId(LeaveId leaveRequestId);




    //************************* UPDATE Operations **************************************************
    int updateLeaveStatus(LeaveId leaveRequestId, LeaveRequestStatus newStatus);



    //************************* INSERT Operations **************************************************

    long insertNew(LeaveRequestInfo leaveInfo, LeaveRequestStatus requestStatus);

    long insertNewLeaveDeductionDetails(LeaveRequestDeductionDetails leaveDeductionInfo, LeaveId leavetId);


}
