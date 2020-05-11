package sa.gov.sfd.leaveapproval.actions;

//import com.google.inject.Inject;
import sa.gov.sfd.leave.core.leaverequest.LeaveId;
import sa.gov.sfd.leaveapproval.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author abdullahalgarni on 07/05/2020 AD
 * @project leaveSys
 **/
@Service
public class ApplyNewLeaveApproval {

    private ApprovalService leaveApprovalService;

    @Autowired
    public ApplyNewLeaveApproval(ApprovalService leaveApprovalService) {
        this.leaveApprovalService = leaveApprovalService;
    }




    public boolean apply(LeaveId leaveId, EmployeeNID employeeNID){
        return leaveApprovalService.applyNewApproval(leaveId,employeeNID);
    }
}
