package sa.gov.sfd.leaveapproval.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leaveapproval.core.LeaveApprovalService;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import sa.gov.sfd.leaveapproval.core.LeaveApprovalTransactionEntity;

import java.util.List;

/**
 * @author abdullahalgarni on 27/04/2020 AD
 * @project leaveSystem
 **/
public class LoadPendingApprovalTransactions {

    private LeaveApprovalService leaveApprovalFlowService;

    @Inject
    public LoadPendingApprovalTransactions(LeaveApprovalService leaveApprovalFlowService) {
        this.leaveApprovalFlowService = leaveApprovalFlowService;
    }

    public List<LeaveApprovalTransactionEntity> loadApprovalPendingByApproverNID(EmployeeNID approverNID){
        return leaveApprovalFlowService.findTransactionsByApproverNID(approverNID);
    }



}
