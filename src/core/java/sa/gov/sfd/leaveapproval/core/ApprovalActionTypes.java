package sa.gov.sfd.leaveapproval.core;

import java.util.Objects;

/**
 * @author abdullahalgarni on 18/04/2020 AD
 * @project leaveSystem
 **/
public class ApprovalActionTypes {

    enum ActionType{
        APPROVE("A"),
        CONFIRM("C"),
        DECLINE("D"),
        PENDING("P");

        private String value;
        ActionType(String p) {
        }

        @Override
        public String toString() {
            return value;
        }

    }
    private ActionType approvalActionType = null;

    public ApprovalActionTypes(String status) {

        switch (status) {
            case "A":
                approvalActionType = ActionType.APPROVE;
                break;

            case "C":
                approvalActionType = ActionType.CONFIRM;
                break;

            case "D":
                approvalActionType = ActionType.DECLINE;
                break;

            default:
                approvalActionType = ActionType.PENDING;
                break;
        }
    }

    public ActionType getApprovalActionType() {
        return approvalActionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApprovalActionTypes that = (ApprovalActionTypes) o;
        return approvalActionType == that.approvalActionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(approvalActionType);
    }

    @Override
    public String toString() {
        return "ApprovalActionTypes{" +
                "approvalActionType=" + approvalActionType +
                '}';
    }
}
