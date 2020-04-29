package sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel;

import java.util.Objects;

/**
 * @author abdullahalgarni on 16/04/2020 AD
 * @project leaveSystem
 **/
public final class processFlowScenarioId {

    private final int Id;

    public processFlowScenarioId(int approvalPathID) {
        this.Id = approvalPathID;
    }

    public int getId() {
        return Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        processFlowScenarioId that = (processFlowScenarioId) o;
        return Id == that.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "ApprovalPathID{" +
                "approvalPathID=" + Id +
                '}';
    }
}
