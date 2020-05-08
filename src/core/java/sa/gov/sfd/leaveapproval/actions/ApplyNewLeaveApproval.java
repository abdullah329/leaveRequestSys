package sa.gov.sfd.leaveapproval.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leave.core.leaverequest.LeaveId;
import sa.gov.sfd.leaveapproval.core.*;
import sa.gov.sfd.leaveapproval.infrastructure.DateOperations;

import java.sql.Timestamp;

/**
 * @author abdullahalgarni on 07/05/2020 AD
 * @project leaveSys
 **/
public class ApplyNewLeaveApproval {

    @Inject private LeaveApprovalService leaveApprovalService;

    public boolean apply(LeaveId leaveId, EmployeeNID employeeNID){
        return leaveApprovalService.applyNewApproval(leaveId,employeeNID);
    }
}
