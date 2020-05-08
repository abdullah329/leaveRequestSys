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
public class LeaveApprovalTransactionEntity {
    private final LeaveApprovalTransactionId transactionId;
    private final LeaveApprovalTransDate leaveApprovalTransDate;
    private final LeaveId leaveRequestId;
    private final ProcessFlowId processId;
    private final List<ApproverTeamEntity> approverTeam;
    private final ApprovalActionTypes approvalActionTypes;
    private final EmployeeNID employeeNID;
    private final String approverNote;

    public LeaveApprovalTransactionEntity(LeaveApprovalTransactionId transactionId, LeaveApprovalTransDate leaveApprovalTransDate,
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


    public LeaveApprovalTransactionId getTransactionId() {
        return transactionId;
    }

    public LeaveApprovalTransDate getLeaveApprovalTransDate() {
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
