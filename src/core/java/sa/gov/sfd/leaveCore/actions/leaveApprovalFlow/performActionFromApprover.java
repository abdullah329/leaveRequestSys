/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.actions.leaveApprovalFlow;

import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.LeaveApprovalFlowService;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.ApprovalActionTypes;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.LeaveApprovalTransactionId;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.LeaveId;

import java.util.NoSuchElementException;

/**
 * @author abdullahalgarni on 27/04/2020 AD
 * @project leaveSystem
 **/
public class performActionFromApprover {

    private LeaveApprovalFlowService leaveApprovalFlowService;

    public boolean acceptLeaveRequest(EmployeeNID employeeNID, LeaveApprovalTransactionId transactionId, LeaveId leaveId){
        leaveApprovalFlowService= new LeaveApprovalFlowService ();
        if(leaveApprovalFlowService.updateActionTypType(transactionId,new ApprovalActionTypes("A"),employeeNID,leaveId)) {
            return true;
        }
        else{
            throw new NoSuchElementException("error");

        }
    }
}
