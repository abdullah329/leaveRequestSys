package sa.gov.sfd.leave.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leave.core.leaverequest.LeaveId;
import sa.gov.sfd.leave.core.leaverequest.LeaveRequestService;
import sa.gov.sfd.leave.core.leaverequest.LeaveRequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author abdullahalgarni on 07/05/2020 AD
 * @project leaveSys
 **/
@Service
public class updateLeaveRequestStatus {


    private LeaveRequestService leaveRequestService;

    @Autowired
    public updateLeaveRequestStatus(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }



    public void updateStatus(LeaveId leaveRequestId , String newLeaveStatus){
        leaveRequestService.updateLeaveStatus(leaveRequestId, new LeaveRequestStatus(newLeaveStatus));
    }
}
