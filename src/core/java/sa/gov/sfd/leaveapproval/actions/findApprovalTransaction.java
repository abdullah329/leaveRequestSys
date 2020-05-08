package sa.gov.sfd.leaveapproval.actions;

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

    public List<LeaveApprovalTransactionEntity> loadAppPendingByApproverNID(EmployeeNID approverNID){

        leaveApprovalFlowService = new LeaveApprovalService();
        return leaveApprovalFlowService.findTransactionsByApproverNID(approverNID);
        //todo more
    }



}
