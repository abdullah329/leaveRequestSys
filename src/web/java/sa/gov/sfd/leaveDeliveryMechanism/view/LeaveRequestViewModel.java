package sa.gov.sfd.leaveDeliveryMechanism.view;


public class LeaveRequestViewModel {

     // some times called ApiModels, or they may be called DTOs
    //https://ardalis.com/your-api-and-view-models-should-not-reference-domain-models

    private Long employeeNID;;
    private String leaveStartDate_AH;
    private int leaveDayRequired;

    public LeaveRequestViewModel(Long employeeNID, String leaveStartDate_AH, int leaveDayRequired) {
        this.employeeNID = employeeNID;
        this.leaveStartDate_AH = leaveStartDate_AH;
        this.leaveDayRequired = leaveDayRequired;
    }

    public Long getEmployeeNID() {
        return employeeNID;
    }

    public String getLeaveStartDate_AH() {
        return leaveStartDate_AH;
    }

    public int getLeaveDayRequired() {
        return leaveDayRequired;
    }
}
