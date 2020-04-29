package sa.gov.sfd.leaveCore.model.leaveApprovalFlow;

import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.infrastructure.repository.LeaveApprovalFlowRepository;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.*;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.operations.LeaveApprovalFlowMethods;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.LeaveId;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveApprovalFlowService {

    private  LeaveApprovalFlowRepository leaveApprovalTransactionRepository;

    private LeaveApprovalFlowMethods leaveApprovalFlowMethods;

    public List<LeaveApprovalTransactionEntity> findTransactionsByLeaveRequestId(LeaveId leaveRequestId){

        return leaveApprovalTransactionRepository.findByLeaveRequestId(leaveRequestId);
    }

    public List<LeaveApprovalTransactionEntity> findTransactionsByApproverNID(EmployeeNID approverNID){

        return leaveApprovalTransactionRepository.findPendingRequestByApproveNID(approverNID);
    }

    public boolean updateActionTypType(LeaveApprovalTransactionId transactionId,
                                    ApprovalActionTypes leaveRequestAction, EmployeeNID employeeNID, LeaveId leaveId ){

        this.leaveApprovalFlowMethods = new LeaveApprovalFlowMethods(employeeNID,leaveId);
        if(leaveApprovalFlowMethods.updateActionTypType(transactionId,leaveRequestAction)){
            return true;
        }
        throw new NoSuchElementException("error");

    }

    /**
     * @param leaveRequestId
     * @return
     */
    public String addNewLeaveApprovalRequestTransaction(LeaveId leaveRequestId, EmployeeNID employeeNID){

        leaveApprovalFlowMethods = new LeaveApprovalFlowMethods(employeeNID,leaveRequestId);

        boolean result = leaveApprovalFlowMethods.addNewTransaction();

        if(result == true){
            return "sucess msg";
        }else{
            return "error msg......";
        }
    }

}
