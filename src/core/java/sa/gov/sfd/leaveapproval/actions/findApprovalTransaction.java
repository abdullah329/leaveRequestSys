package sa.gov.sfd.leaveapproval.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import sa.gov.sfd.leaveapproval.core.LeaveApprovalService;
import sa.gov.sfd.leaveapproval.core.LeaveApprovalTransactionEntity;

import java.util.List;

/**
 * @author abdullahalgarni on 27/04/2020 AD
 * @project leaveSystem
 **/
public class findApprovalTransaction {

    private LeaveApprovalService leaveApprovalFlowService;

    @Inject
    public findApprovalTransaction(LeaveApprovalService leaveApprovalFlowService) {
        this.leaveApprovalFlowService = leaveApprovalFlowService;
    }

    public List<LeaveApprovalTransactionEntity> loadAppPendingByApproverNID(EmployeeNID approverNID){
        return leaveApprovalFlowService.findTransactionsByApproverNID(approverNID);
    }



}
