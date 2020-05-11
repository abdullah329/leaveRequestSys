/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveapproval.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leaveapproval.core.ApprovalService;
import sa.gov.sfd.leaveapproval.core.ApprovalTransactionId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

/**
 * @author abdullahalgarni on 27/04/2020 AD
 * @project leaveSystem
 **/

@Service
public class performApproverActions {

    private ApprovalService leaveApprovalFlowService;

    @Autowired
    public performApproverActions(ApprovalService leaveApprovalFlowService) {
        this.leaveApprovalFlowService = leaveApprovalFlowService;
    }

    public boolean acceptLeaveRequest(ApprovalTransactionId transactionId){
        if(leaveApprovalFlowService.updateActionType(transactionId,"A")) {
            return true;
        }
        else{
            throw new NoSuchElementException("error");

        }
    }


    public boolean declineLeaveRequest(ApprovalTransactionId transactionId){
        if(leaveApprovalFlowService.updateActionType(transactionId,"D")) {
            return true;
        }
        else{
            throw new NoSuchElementException("error");

        }
    }

    public boolean confirmedLeaveRequest(ApprovalTransactionId transactionId){
        if(leaveApprovalFlowService.updateActionType(transactionId,"C")) {
            return true;
        }
        else{
            throw new NoSuchElementException("error");

        }
    }
}
