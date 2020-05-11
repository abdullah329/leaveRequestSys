package sa.gov.sfd.leaveapproval.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leaveapproval.core.ApprovalService;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import sa.gov.sfd.leaveapproval.core.ApprovalTransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author abdullahalgarni on 27/04/2020 AD
 * @project leaveSystem
 **/
@Service
public class LoadPendingApprovalTransactions {

    private ApprovalService leaveApprovalFlowService;

    @Autowired
    public LoadPendingApprovalTransactions(ApprovalService leaveApprovalFlowService) {
        this.leaveApprovalFlowService = leaveApprovalFlowService;
    }

    public List<ApprovalTransactionEntity> loadApprovalPendingByApproverNID(EmployeeNID approverNID){
        return leaveApprovalFlowService.findTransactionsByApproverNID(approverNID);
    }



}
