package sa.gov.sfd.leaveapproval.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leave.core.leaverequest.LeaveId;
import sa.gov.sfd.leaveapproval.core.*;

/**
 * @author abdullahalgarni on 07/05/2020 AD
 * @project leaveSys
 **/
public class ApplyNewLeaveApproval {

    private LeaveApprovalService leaveApprovalService;

    @Inject
    public ApplyNewLeaveApproval(LeaveApprovalService leaveApprovalService) {
        this.leaveApprovalService = leaveApprovalService;
    }

    public boolean apply(LeaveId leaveId, EmployeeNID employeeNID){
        return leaveApprovalService.applyNewApproval(leaveId,employeeNID);
    }
}
