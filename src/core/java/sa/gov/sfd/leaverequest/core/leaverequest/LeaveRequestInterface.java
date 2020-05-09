/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaverequest.core.leaverequest;

import sa.gov.sfd.leaveapproval.core.EmployeeNID;

import java.util.List;

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
