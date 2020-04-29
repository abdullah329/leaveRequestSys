/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveApprovalFlow.operations;

import sa.gov.sfd.leaveCore.infrastructure.calendar.DateOperations;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.*;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.infrastructure.repository.LeaveApprovalFlowRepository;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.LeaveId;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Comparator.comparing;

/**
 * @author abdullahalgarni on 25/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveApprovalFlowMethods {


    private LeaveApprovalFlowRepository leaveApprovalTransactionRepository;
    private final List<LeaveApprovalProcessesFlowEntity> leaveApprovalProcessesSteps;
    private final LastApprovalTransactionLine lastApprovalTransactionLine;
    private final EmployeeNID employeeNID;
    private final LeaveId leaveId;
    private DateOperations dateOperations;


    //Constructor
    public LeaveApprovalFlowMethods(EmployeeNID employeeNID, LeaveId leaveRequestId) {
       // this.leaveApprovalTransactionRepository = leaveApprovalTransactionRepository;
        this.employeeNID=employeeNID;
        this.leaveId = leaveRequestId;
        this.leaveApprovalProcessesSteps = loadLeaveApprovalProcessesByEmployeeNID(employeeNID);
        sortLeaveApprovalProcessesSteps();

        this.lastApprovalTransactionLine = leaveApprovalTransactionRepository.findLastStepNumberByLeaveId(leaveRequestId);
    }

    public List<LeaveApprovalProcessesFlowEntity> loadLeaveApprovalProcessesByEmployeeNID(EmployeeNID employeeNID){

        return leaveApprovalTransactionRepository.loadLeaveProcessScenarioByEmployeeNID(employeeNID);
    }

    private boolean addNewLeaveApprovalRequestTransactionIntoRepository(NextApprovalTransactionLine nextApprovalTransactionLine){


        LeaveApprovalTransDate leaveApprovalTransDate = new LeaveApprovalTransDate(dateOperations.nowHijri(),
                dateOperations.nowGregorian());
        Timestamp requestTimeStamp = new Timestamp(System.currentTimeMillis());

        int queryExecutionResult = leaveApprovalTransactionRepository.insertNewTransaction(
                new LeaveApprovalTransactionEntity(
                        new LeaveApprovalTransactionId(0), leaveApprovalTransDate, nextApprovalTransactionLine.getLeaveRequestId(),
                        nextApprovalTransactionLine.getNextProcessId(), nextApprovalTransactionLine.getApproverTeam(),
                        new ApprovalActionTypes("P"), requestTimeStamp, null, employeeNID, null));

        if(queryExecutionResult == 0){
            return true;
        }else{
            return false;
        }
    }

    private void sortLeaveApprovalProcessesSteps(){
        //sort the list by scenario id
        this.leaveApprovalProcessesSteps.sort(comparing(x ->x.getScenarioStepId().getId()));
    }

    private int getScenarioLastStep(){

        return this.leaveApprovalProcessesSteps.get(this.leaveApprovalProcessesSteps.size()).getProcessStepNumber();

    }

    private LastApprovalTransactionLine getLastApprovalTransactionLine(){
        return this.lastApprovalTransactionLine;
    }

    private int getIndexOfLastProcess(){
        return leaveApprovalProcessesSteps.indexOf(getLastApprovalTransactionLine().getProcessId().getId());
    }

    private int getNextScenarioStepNumber(){
          int nextStepNumber = -1;
        if(getIndexOfLastProcess() < leaveApprovalProcessesSteps.size()) {
            nextStepNumber = this.leaveApprovalProcessesSteps.get(getIndexOfLastProcess()+1).getProcessStepNumber();

        }
        return nextStepNumber;
    }

    private List<ApproverTeamEntity> getNextApproverTeams(){
        List<ApproverTeamEntity> nextApproverTeam = new ArrayList<>();
        if(getIndexOfLastProcess() < leaveApprovalProcessesSteps.size()) {
            nextApproverTeam = leaveApprovalProcessesSteps.get(getIndexOfLastProcess()+1).getApproverAndRols();
        }
        return nextApproverTeam;
    }

    public boolean updateActionTypType(LeaveApprovalTransactionId trasactionId,
                                    ApprovalActionTypes leaveRequestAction){


        int result = leaveApprovalTransactionRepository.updateActionType(trasactionId,leaveRequestAction);

        if(result != 0){
            return addNewTransaction();
        }else  throw new NoSuchElementException("error");
    }

    private ProcessFlowId getNextApprovalProcessId(){
        int nextProcessId = -1;
        if(getNextScenarioStepNumber() > -1) {
             nextProcessId = leaveApprovalProcessesSteps.indexOf(getNextScenarioStepNumber());
        }
        return new ProcessFlowId(nextProcessId);
    }

    private NextApprovalTransactionLine findNextApprovalTransactionLine(){
        return new NextApprovalTransactionLine(this.leaveId, getNextApprovalProcessId(),getNextScenarioStepNumber(), getNextApproverTeams(),this.employeeNID);
    }

    public boolean addNewTransaction() {

        if(getLastApprovalTransactionLine().getProcessStepNumber() == getScenarioLastStep()){
            throw new NoSuchElementException("last step");
        }
        else {
            if(getNextApprovalProcessId().getId() == -1) {
                throw new NoSuchElementException("error or last step");

            }
            return addNewLeaveApprovalRequestTransactionIntoRepository(findNextApprovalTransactionLine());

        }
    }

        public void fetchNextAproversGroup(LeaveId leavetId, EmployeeNID employeeNID){


    }


}
