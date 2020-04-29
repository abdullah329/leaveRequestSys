/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */


package sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel;

import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.LeaveId;
import java.sql.Timestamp;

/**
 * @author abdullahalgarni on 15/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveApprovalTransactionEntity {
    private final LeaveApprovalTransactionId transactionId;
    private final LeaveApprovalTransDate leaveApprovalTransDate;
    private final LeaveId leaveRequestId;
    private final ProcessFlowId processId;
    private final ApproverTeamEntity approverTeam;
    private final ApprovalActionTypes approvalActionTypes;

    private final Timestamp requestTimeStamp;
    private final Timestamp actionTimeStamp;

    private final EmployeeNID employeeNID;
    private final String approverNote;

    public LeaveApprovalTransactionEntity(LeaveApprovalTransactionId transactionId, LeaveApprovalTransDate leaveApprovalTransDate,
                                          LeaveId leaveRequestId,
                                          ProcessFlowId leaveApprovalGroupDptId,
                                          ApproverTeamEntity approverTeam,
                                          ApprovalActionTypes leaveRequestAction,
                                          Timestamp requestTimeStamp,
                                          Timestamp actionTimeStamp, EmployeeNID employeeNID, String approverNote) {
        this.transactionId = transactionId;

        this.leaveApprovalTransDate = leaveApprovalTransDate;
        this.leaveRequestId = leaveRequestId;
        this.processId = leaveApprovalGroupDptId;
        this.approverTeam = approverTeam;
        this.approvalActionTypes = leaveRequestAction;
        this.employeeNID = employeeNID;
        if(requestTimeStamp==null){
            this.requestTimeStamp =new Timestamp(System.currentTimeMillis());
        }
        else {
            this.requestTimeStamp = requestTimeStamp;
        }
        this.actionTimeStamp = actionTimeStamp;
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

    public ApproverTeamEntity getapproverTeam() {
        return approverTeam;
    }

    public ApprovalActionTypes getApprovalActionTypes() {
        return approvalActionTypes;
    }

    public Timestamp getRequestTimeStamp() {
        return requestTimeStamp;
    }

    public Timestamp getActionTimeStamp() {
        return actionTimeStamp;
    }

    public ApproverTeamEntity getApproverTeam() {
        return approverTeam;
    }

    public EmployeeNID getEmployeeNID() {
        return employeeNID;
    }

    public String getApproverNote() {
        return approverNote;
    }


}
