/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveapproval.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leave.core.leaverequest.LeaveId;
import sa.gov.sfd.leaveapproval.core.LeaveApprovalService;
import sa.gov.sfd.leaveapproval.core.ApprovalActionTypes;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import sa.gov.sfd.leaveapproval.core.LeaveApprovalTransactionId;

import java.util.NoSuchElementException;

/**
 * @author abdullahalgarni on 27/04/2020 AD
 * @project leaveSystem
 **/
public class performApproverActions {

    @Inject private LeaveApprovalService leaveApprovalFlowService;

    public boolean acceptLeaveRequest(EmployeeNID employeeNID, LeaveApprovalTransactionId transactionId, LeaveId leaveId){
        leaveApprovalFlowService= new LeaveApprovalService();
        if(leaveApprovalFlowService.updateActionType(transactionId,new ApprovalActionTypes("A"),employeeNID,leaveId)) {
            return true;
        }
        else{
            throw new NoSuchElementException("error");

        }
    }


    public boolean declineLeaveRequest(EmployeeNID employeeNID, LeaveApprovalTransactionId transactionId, LeaveId leaveId){
        leaveApprovalFlowService= new LeaveApprovalService();
        if(leaveApprovalFlowService.updateActionType(transactionId,new ApprovalActionTypes("D"),employeeNID,leaveId)) {
            return true;
        }
        else{
            throw new NoSuchElementException("error");

        }
    }

    public boolean confirmedLeaveRequest(EmployeeNID employeeNID, LeaveApprovalTransactionId transactionId, LeaveId leaveId){
        leaveApprovalFlowService= new LeaveApprovalService();
        if(leaveApprovalFlowService.updateActionType(transactionId,new ApprovalActionTypes("C"),employeeNID,leaveId)) {
            return true;
        }
        else{
            throw new NoSuchElementException("error");

        }
    }
}
