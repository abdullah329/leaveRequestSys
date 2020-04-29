/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel;

import java.util.List;

/**
 * @author abdullahalgarni on 15/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveApprovalProcessesFlowEntity {

    private ProcessFlowId processId;
    private processFlowScenarioId scenarioStepId; // one or more employee will be assign to one scenario , usually each department or section has one scenario
    private int processStepNumber;
    private List<ApproverTeamEntity> approverAndRols;


    public ProcessFlowId getProcessId() {
        return processId;
    }

    public processFlowScenarioId getScenarioStepId() {
        return scenarioStepId;
    }

    public int getProcessStepNumber() {
        return processStepNumber;
    }

    public List<ApproverTeamEntity> getApproverAndRols() {
        return approverAndRols;
    }

    public void setProcessId(ProcessFlowId processId) {
        this.processId = processId;
    }

    public void setScenarioStepId(processFlowScenarioId scenarioStepId) {
        this.scenarioStepId = scenarioStepId;
    }

    public void setProcessStepNumber(int processStepNumber) {
        this.processStepNumber = processStepNumber;
    }

    public void setApproverAndRols(List<ApproverTeamEntity> approverAndRols) {
        this.approverAndRols = approverAndRols;
    }
}
