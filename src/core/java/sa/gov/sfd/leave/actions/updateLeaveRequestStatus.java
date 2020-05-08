package sa.gov.sfd.leave.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leave.core.leaverequest.LeaveId;
import sa.gov.sfd.leave.core.leaverequest.LeaveRequestService;
import sa.gov.sfd.leave.core.leaverequest.LeaveRequestStatus;

/**
 * @author abdullahalgarni on 07/05/2020 AD
 * @project leaveSys
 **/
public class updateLeaveRequestStatus {


    @Inject
    private LeaveRequestService leaveRequestService;

    public void updateStatus(LeaveId leaveRequestId , String newLeaveStatus){
        leaveRequestService.updateLeaveStatus(leaveRequestId, new LeaveRequestStatus(newLeaveStatus));
    }
}
