package sa.gov.sfd.leaveapproval.core;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/
public class ApproverRoles {


    private final int approveRole; // o not allowed , 1 allowed
    private final int declineRole; // o not allowed , 1 allowed
    private final int viewRole; // o not allowed , 1 allowed
    private final int confirmRole; //  o not allowed , 1 allowed ;; this is final step and generateFinalDecisionNumber


    public ApproverRoles(int approve, int decline, int view, int confirm) {

        this.approveRole = approve;
        this.declineRole = decline;
        this.viewRole = view;
        this.confirmRole = confirm;
    }


    public int getApproveRole() {
        return approveRole;
    }

    public int getDeclineRole() {
        return declineRole;
    }

    public int getViewRole() {
        return viewRole;
    }

    public int getConfirmRole() {
        return confirmRole;
    }


}
