
/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveapproval.core;
import sa.gov.sfd.leaverequest.core.leaverequest.LeaveId;
import java.util.List;

/**
 * @author abdullahalgarni on 08/05/2020 AD
 * @project leaveSystem
 **/
public interface LeaveApprovalInterface {



     List<LeaveApprovalTransactionEntity> findByLeaveRequestId(LeaveId leaveRequestId);

     List<LeaveApprovalProcessesEntity> loadLeaveProcessScenarioByEmployeeNID(EmployeeNID approverNID);

     CurrentApprovalTransactionLine findCurrentApprovalStepByLeaveId(LeaveId leaveId);

     List<LeaveApprovalTransactionEntity> findPendingRequestByApproveNID(EmployeeNID approverNID);

     List<Integer> findAllapproverTeamListByApproverId(EmployeeNID pApproverNID);

     List<EmployeeEntity> findAllEmplyee();


    //************************* UPDATE Operations **************************************************

    int updateActionType(LeaveApprovalTransactionId transactionId, ApprovalActionTypes action);


    //************************* INSERT Operations **************************************************

    int insertNewTransaction(LeaveApprovalTransactionEntity leaveInfo);

    int insertNewEmployee(EmployeeEntity empInfo);
}

