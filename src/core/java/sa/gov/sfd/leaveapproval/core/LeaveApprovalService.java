package sa.gov.sfd.leaveapproval.core;

import com.google.inject.Inject;
import sa.gov.sfd.leaveapproval.infrastructure.DateOperations;
import sa.gov.sfd.leaverequest.core.leaverequest.LeaveId;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveApprovalService {

    private LeaveApprovalInterface leaveApprovalTransactionRepository;
    private DateOperations dateOperations;

    @Inject
    public LeaveApprovalService(LeaveApprovalInterface leaveApprovalTransactionRepository, DateOperations dateOperations) {
        this.leaveApprovalTransactionRepository = leaveApprovalTransactionRepository;
        this.dateOperations = dateOperations;
    }

    public List<LeaveApprovalTransactionEntity> findTransactionsByLeaveRequestId(LeaveId leaveRequestId){

        return leaveApprovalTransactionRepository.findByLeaveRequestId(leaveRequestId);
    }

    public List<LeaveApprovalTransactionEntity> findTransactionsByApproverNID(EmployeeNID approverNID){

        return leaveApprovalTransactionRepository.findPendingRequestByApproveNID(approverNID);
    }

    public boolean updateActionType(LeaveApprovalTransactionId transactionId,
                                    String leaveRequestAction ){

        int result = leaveApprovalTransactionRepository.updateActionType(transactionId,new ApprovalActionTypes(leaveRequestAction));

        if(result != 0){
            return true;
        }else  throw new NoSuchElementException("error");

    }


    public boolean applyNewApproval(LeaveId leaveId, EmployeeNID employeeNID){


        LeaveApprovalTransDate leaveApprovalTransDate = new LeaveApprovalTransDate(dateOperations.nowHijri(),
                dateOperations.nowGregorian());
        NextApprovalTransactionLine nextApprovalProcess = findNextApprovalStep(employeeNID,leaveId);
        int queryExecutionResult = leaveApprovalTransactionRepository.insertNewTransaction(
                new LeaveApprovalTransactionEntity(
                        new LeaveApprovalTransactionId(0), leaveApprovalTransDate,
                        nextApprovalProcess.getLeaveRequestId(),
                        nextApprovalProcess.getNextProcessId(),
                        nextApprovalProcess.getApproverTeam(),
                        new ApprovalActionTypes("P"), null, null));

        if(queryExecutionResult == 0){
            return true;
        }else{
            return false;
        }
        
    }
    


    public NextApprovalTransactionLine findNextApprovalStep(EmployeeNID employeeNID,LeaveId leaveId){
        return new NextApprovalTransactionLine(leaveId,
                findNextApprovalProcessId(employeeNID,leaveId), findNextScenarioStepNumber(employeeNID,leaveId),
                findNextApproverTeams(employeeNID,leaveId),employeeNID);
    }


    private ProcessFlowId findNextApprovalProcessId(EmployeeNID employeeNID,LeaveId leaveId){
        int nextProcessId = -1;
        int nextScenarioProcessStep =findNextScenarioStepNumber(employeeNID,leaveId);
        if(nextScenarioProcessStep > -1) {
            nextProcessId = loadLeaveApprovalProcesses(employeeNID).indexOf(nextScenarioProcessStep);
        }
        return new ProcessFlowId(nextProcessId);
    }

    private List<ApproverTeamEntity> findNextApproverTeams(EmployeeNID employeeNID,LeaveId leaveId){
        List<ApproverTeamEntity> nextApproverTeam = new ArrayList<>();
        int currentProcessStep= findIndexOfCurrentProcessStep(employeeNID,leaveId);
        if(currentProcessStep < loadLeaveApprovalProcesses(employeeNID).size()) {
            nextApproverTeam = loadLeaveApprovalProcesses(employeeNID).get(currentProcessStep+1).getApproverAndRols();
        }
        return nextApproverTeam;
    }
    private int findNextScenarioStepNumber(EmployeeNID employeeNID,LeaveId leaveId){
        int nextStepNumber = -1;
        int currentProcessStep= findIndexOfCurrentProcessStep(employeeNID,leaveId);
        if(currentProcessStep < loadLeaveApprovalProcesses(employeeNID).size()) {
            nextStepNumber = loadLeaveApprovalProcesses(employeeNID).get(currentProcessStep+1).getProcessStepNumber();

        }
        return nextStepNumber;
    }

    public List<LeaveApprovalProcessesEntity> loadLeaveApprovalProcesses(EmployeeNID employeeNID){

        return leaveApprovalTransactionRepository.loadLeaveProcessScenarioByEmployeeNID(employeeNID);
    }

    private int findIndexOfCurrentProcessStep(EmployeeNID employeeNID, LeaveId leaveId){

        return loadLeaveApprovalProcesses(employeeNID).indexOf(findCurrentApprovalStep(leaveId).getProcessId().getId());
    }


    public CurrentApprovalTransactionLine findCurrentApprovalStep(LeaveId leaveRequestId){
        return leaveApprovalTransactionRepository.findCurrentApprovalStepByLeaveId(leaveRequestId);
    }

}
