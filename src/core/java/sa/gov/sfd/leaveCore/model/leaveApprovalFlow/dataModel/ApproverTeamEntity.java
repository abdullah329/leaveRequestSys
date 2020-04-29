package sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/
public class ApproverTeamEntity {

    private final ApproverTeamId approverTeamId;
    private final EmployeeNID employeeNID;
    private final ApproverRoles approverRoles;

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
