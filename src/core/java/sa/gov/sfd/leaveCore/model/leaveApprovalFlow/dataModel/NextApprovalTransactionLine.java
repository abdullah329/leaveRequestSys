/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel;

import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.LeaveId;

import java.util.List;
import java.util.Objects;

/**
 * @author abdullahalgarni on 26/04/2020 AD
 * @project leaveSystem
 **/
public class NextApprovalTransactionLine {
    private final LeaveId leaveRequestId;
    private final ProcessFlowId nextProcessId;
    private int processStepNumber;

    private final ApproverTeamEntity approverTeam;
    private final EmployeeNID employeeNID;


    public NextApprovalTransactionLine(LeaveId leaveRequestId, ProcessFlowId processId , int processStepNumber, List<ApproverTeamEntity> approverTeam, EmployeeNID employeeNID) {

        this.leaveRequestId = leaveRequestId;
        this.nextProcessId = processId;

        this.processStepNumber = processStepNumber;
        this.approverTeam = approverTeam;
        this.employeeNID = employeeNID;
    }



    public LeaveId getLeaveRequestId() {
        return leaveRequestId;
    }

    public ProcessFlowId getNextProcessId() {
        return nextProcessId;
    }

    public int getProcessStepNumber() {
        return processStepNumber;
    }

    public ApproverTeamEntity getApproverTeam() {
        return approverTeam;
    }

    public EmployeeNID getEmployeeNID() {
        return employeeNID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NextApprovalTransactionLine that = (NextApprovalTransactionLine) o;
        return processStepNumber == that.processStepNumber &&
                Objects.equals(leaveRequestId, that.leaveRequestId) &&
                Objects.equals(nextProcessId, that.nextProcessId) &&
                Objects.equals(approverTeam, that.approverTeam) &&
                Objects.equals(employeeNID, that.employeeNID);
    }

    @Override
    public int hashCode() {
        return Objects.hash( leaveRequestId, nextProcessId, processStepNumber, approverTeam, employeeNID);
    }

    @Override
    public String toString() {
        return "approvalTransactionLine{" +
                ", leaveRequestId=" + leaveRequestId +
                ", processId=" + nextProcessId +
                ", processStepNumber=" + processStepNumber +
                ", approverTeamId=" + approverTeam +
                ", employeeNID=" + employeeNID +
                '}';
    }
}
