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
    private final ApprovalTransactionId transactionId;
    private final ApprovalTransDate leaveApprovalTransDate;
    private final LeaveId leaveRequestId;
    private final ProcessFlowId processId;
    private final List<ApproverTeamEntity> approverTeam;
    private final ApprovalActionTypes approvalActionTypes;
    private final EmployeeNID employeeNID;
    private final String approverNote;

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
