/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveapproval.core;
import sa.gov.sfd.leaverequest.core.leaverequest.LeaveId;

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
    private final List<ApproverTeamEntity> approverTeam;
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

    public List<ApproverTeamEntity> getApproverTeam() {
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
                leaveRequestId.equals(that.leaveRequestId) &&
                nextProcessId.equals(that.nextProcessId) &&
                approverTeam.equals(that.approverTeam) &&
                employeeNID.equals(that.employeeNID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaveRequestId, nextProcessId, processStepNumber, approverTeam, employeeNID);
    }

    @Override
    public String toString() {
        return "NextApprovalTransactionLine{" +
                "leaveRequestId=" + leaveRequestId +
                ", nextProcessId=" + nextProcessId +
                ", processStepNumber=" + processStepNumber +
                ", approverTeam=" + approverTeam +
                ", employeeNID=" + employeeNID +
                '}';
    }
}
