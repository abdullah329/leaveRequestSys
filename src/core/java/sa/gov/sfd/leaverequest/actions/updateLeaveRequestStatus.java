package sa.gov.sfd.leaverequest.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leaverequest.core.leaverequest.LeaveId;
import sa.gov.sfd.leaverequest.core.leaverequest.LeaveRequestService;
import sa.gov.sfd.leaverequest.core.leaverequest.LeaveRequestStatus;

/**
 * @author abdullahalgarni on 07/05/2020 AD
 * @project leaveSys
 **/
public class updateLeaveRequestStatus {


    private LeaveRequestService leaveRequestService;

    @Inject
    public updateLeaveRequestStatus() {
    }

    public void updateStatus(LeaveId leaveRequestId , String newLeaveStatus){
        leaveRequestService.updateLeaveStatus(leaveRequestId, new LeaveRequestStatus(newLeaveStatus));
    }
}
