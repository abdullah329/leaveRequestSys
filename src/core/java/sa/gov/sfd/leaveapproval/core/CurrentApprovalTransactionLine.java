/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveapproval.core;

import leaverequest.leaveRequest.core.LeaveId;

import java.util.Objects;

/**
 * @author abdullahalgarni on 26/04/2020 AD
 * @project leaveSystem
 **/
public class CurrentApprovalTransactionLine {
    private final LeaveApprovalTransDate leaveApprovalTransDate;
    private final LeaveId leaveRequestId;

    private final ProcessFlowId processId;
    private processFlowScenarioId approvalScenarioId; // all employee in one department, section ,  or group will have one DeptOrGroupId which determine their approval flow steps
    private int processStepNumber;

    private final ApproverTeamId approverTeamId;
    private final EmployeeNID employeeNID;


    public CurrentApprovalTransactionLine(LeaveApprovalTransDate leaveApprovalTransDate, LeaveId leaveRequestId, ProcessFlowId processId, processFlowScenarioId approvalScenarioId, int processStepNumber, ApproverTeamId approverTeamId, EmployeeNID employeeNID) {
        this.leaveApprovalTransDate = leaveApprovalTransDate;
        this.leaveRequestId = leaveRequestId;
        this.processId = processId;
        this.approvalScenarioId = approvalScenarioId;
        this.processStepNumber = processStepNumber;
        this.approverTeamId = approverTeamId;
        this.employeeNID = employeeNID;
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

    public processFlowScenarioId getApprovalScenarioId() {
        return approvalScenarioId;
    }

    public int getProcessStepNumber() {
        return processStepNumber;
    }

    public ApproverTeamId getApproverTeamId() {
        return approverTeamId;
    }

    public EmployeeNID getEmployeeNID() {
        return employeeNID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentApprovalTransactionLine that = (CurrentApprovalTransactionLine) o;
        return processStepNumber == that.processStepNumber &&
                Objects.equals(leaveApprovalTransDate, that.leaveApprovalTransDate) &&
                Objects.equals(leaveRequestId, that.leaveRequestId) &&
                Objects.equals(processId, that.processId) &&
                Objects.equals(approvalScenarioId, that.approvalScenarioId) &&
                Objects.equals(approverTeamId, that.approverTeamId) &&
                Objects.equals(employeeNID, that.employeeNID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaveApprovalTransDate, leaveRequestId, processId, approvalScenarioId, processStepNumber, approverTeamId, employeeNID);
    }

    @Override
    public String toString() {
        return "approvalTransactionLine{" +
                "leaveApprovalTransDate=" + leaveApprovalTransDate +
                ", leaveRequestId=" + leaveRequestId +
                ", processId=" + processId +
                ", approvalScenarioId=" + approvalScenarioId +
                ", processStepNumber=" + processStepNumber +
                ", approverTeamId=" + approverTeamId +
                ", employeeNID=" + employeeNID +
                '}';
    }
}
