
/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel;

import java.util.Objects;

/**
 * @author abdullahalgarni on 16/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveApprovalTransactionId {

    private final int Id;

    public LeaveApprovalTransactionId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveApprovalTransactionId that = (LeaveApprovalTransactionId) o;
        return Id == that.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "LeaveApprovalTrasactionId{" +
                "Id=" + Id +
                '}';
    }
}
