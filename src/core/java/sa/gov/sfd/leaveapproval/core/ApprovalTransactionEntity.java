/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */


package sa.gov.sfd.leaveapproval.core;
import sa.gov.sfd.leave.core.leaverequest.LeaveId;

import java.util.List;

/**
 * @author abdullahalgarni on 15/04/2020 AD
 * @project leaveSystem
 **/
public class ApprovalTransactionEntity {
    private  ApprovalTransactionId transactionId;
    private  ApprovalTransDate leaveApprovalTransDate;
    private  LeaveId leaveRequestId;
    private  ProcessFlowId processId;
    private  List<ApproverTeamEntity> approverTeam;
    private  ApprovalActionTypes approvalActionTypes;
    private  EmployeeNID employeeNID;
    private  String approverNote;

    public ApprovalTransactionEntity(ApprovalTransactionId transactionId, ApprovalTransDate leaveApprovalTransDate,
                                     LeaveId leaveRequestId,
                                     ProcessFlowId leaveApprovalGroupDptId,
                                     List<ApproverTeamEntity> approverTeam,
                                     ApprovalActionTypes leaveRequestAction,
                                     EmployeeNID employeeNID, String approverNote) {
        this.transactionId = transactionId;

        this.leaveApprovalTransDate = leaveApprovalTransDate;
        this.leaveRequestId = leaveRequestId;
        this.processId = leaveApprovalGroupDptId;
        this.approverTeam = approverTeam;
        this.approvalActionTypes = leaveRequestAction;
        this.employeeNID = employeeNID;
        this.approverNote= approverNote;
    }


    public ApprovalTransactionId getTransactionId() {
        return transactionId;
    }

    public ApprovalTransDate getLeaveApprovalTransDate() {
        return leaveApprovalTransDate;
    }

    public LeaveId getLeaveRequestId() {
        return leaveRequestId;
    }

    public ProcessFlowId getProcessId() {
        return processId;
    }

    public List<ApproverTeamEntity> getApproverTeam() {
        return approverTeam;
    }

    public ApprovalActionTypes getApprovalActionTypes() {
        return approvalActionTypes;
    }

    public EmployeeNID getEmployeeNID() {
        return employeeNID;
    }

    public String getApproverNote() {
        return approverNote;
    }


}
