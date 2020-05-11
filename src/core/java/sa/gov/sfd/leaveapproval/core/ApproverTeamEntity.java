package sa.gov.sfd.leaveapproval.core;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/
public class ApproverTeamEntity {

    private  ApproverTeamId approverTeamId;
    private  EmployeeNID employeeNID;
    private  ApproverRoles approverRoles;

    public ApproverTeamEntity(ApproverTeamId approverTeamId, EmployeeNID employeeNIDs, ApproverRoles approverRoles) {
        this.approverTeamId = approverTeamId;
        this.employeeNID = employeeNIDs;
        this.approverRoles = approverRoles;
    }

   public ApproverTeamId getApproverTeamId() { return approverTeamId; }

    public EmployeeNID getEmployeeNID() {
        return employeeNID;
    }

    public ApproverRoles getApproverRoles() {
        return approverRoles;
    }
}
