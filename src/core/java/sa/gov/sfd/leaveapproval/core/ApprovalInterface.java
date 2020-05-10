
/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveapproval.core;
import sa.gov.sfd.leave.core.leaverequest.LeaveId;
import java.util.List;

/**
 * @author abdullahalgarni on 08/05/2020 AD
 * @project leaveSystem
 **/
public interface ApprovalInterface {



     List<ApprovalTransactionEntity> findByLeaveRequestId(LeaveId leaveRequestId);

     List<ApprovalProcessesEntity> loadLeaveProcessScenarioByEmployeeNID(EmployeeNID approverNID);

     CurrentApprovalTransactionLine findCurrentApprovalStepByLeaveId(LeaveId leaveId);

     List<ApprovalTransactionEntity> findPendingRequestByApproveNID(EmployeeNID approverNID);

     List<Integer> findAllapproverTeamListByApproverId(EmployeeNID pApproverNID);

     List<EmployeeEntity> findAllEmplyee();


    //************************* UPDATE Operations **************************************************

    int updateActionType(ApprovalTransactionId transactionId, ApprovalActionTypes action);


    //************************* INSERT Operations **************************************************

    int insertNewTransaction(ApprovalTransactionEntity leaveInfo);

    int insertNewEmployee(EmployeeEntity empInfo);
}

