package sa.gov.sfd.leaveCore.actions.leaveRequest;
import sa.gov.sfd.leaveCore.infrastructure.calendar.DateOperations;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.LeaveApprovalFlowService;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveRequest.LeaveRequestService;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.LeaveId;

public class AddNewLeaveRequest {

    private LeaveRequestService leaveRequestService;
    private LeaveApprovalFlowService leaveApprovalFlowService;
    private DateOperations dateOperations;

    public  void checkingLeaveAvailableCredit(){

        //todo

    }
    public  boolean addNewLeave(EmployeeNID employeeNID, String leaveStartDate_AH, int numberOfLeaveDaysRequired){

        try {
            this.leaveRequestService = new LeaveRequestService(employeeNID);

            long leaveId = this.leaveRequestService.addNewLeaveRequest(dateOperations.formateHijri(leaveStartDate_AH), numberOfLeaveDaysRequired);

            callForApproval(new LeaveId(leaveId), employeeNID);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    public void callForApproval(LeaveId leavetId, EmployeeNID employeeNID){

        leaveApprovalFlowService.addNewLeaveApprovalRequestTransaction(leavetId,employeeNID);

    }
}
