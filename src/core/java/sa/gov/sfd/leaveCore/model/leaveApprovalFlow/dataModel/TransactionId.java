/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel;

import java.util.Objects;

/**
 * @author abdullahalgarni on 26/04/2020 AD
 * @project leaveSystem
 **/
public class TransactionId {
    private final int Id;

    public TransactionId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionId that = (TransactionId) o;
        return Id == that.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "ApproverTeamId{" +
                "Id=" + Id +
                '}';
    }
}
