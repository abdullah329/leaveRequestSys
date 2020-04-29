package sa.gov.sfd.leaveCore.actions.leaveApprovalFlow;

import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.LeaveApprovalFlowService;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.LeaveApprovalTransactionEntity;

import java.util.List;

/**
 * @author abdullahalgarni on 27/04/2020 AD
 * @project leaveSystem
 **/
public class LoadPendingTransaction {

    private LeaveApprovalFlowService leaveApprovalFlowService;

    public List<LeaveApprovalTransactionEntity> loadAppPendingByApproverNID(EmployeeNID approverNID){

        leaveApprovalFlowService = new LeaveApprovalFlowService();
        return leaveApprovalFlowService.findTransactionsByApproverNID(approverNID);
        //todo more
    }



}
