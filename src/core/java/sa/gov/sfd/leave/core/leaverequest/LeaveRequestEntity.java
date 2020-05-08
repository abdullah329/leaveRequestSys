/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */


package sa.gov.sfd.leave.core.leaverequest;

import java.util.List;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/

public class LeaveRequestEntity {

    private LeaveId leaveId;
    private LeaveRequestInfo leaveRequestDetailsInfo;
    private LeaveRequestStatus requestStatus;
    private List<LeaveRequestDeductionDetails> leaveRequestDeductionDetails; // ex : for requesting 15 days leave => if entitlement in year 2018 is 8 and in year 2019 is 15 , then system deducts the 8 days from 2018 and the rest from 2019

    public LeaveId getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(LeaveId leaveId) {
        this.leaveId = leaveId;
    }

    public LeaveRequestInfo getLeaveRequestDetailsInfo() {
        return leaveRequestDetailsInfo;
    }

    public void setLeaveRequestDetailsInfo(LeaveRequestInfo leaveRequestDetailsInfo) {
        this.leaveRequestDetailsInfo = leaveRequestDetailsInfo;
    }

    public List<LeaveRequestDeductionDetails> getLeaveRequestDeductionDetails() {
        return leaveRequestDeductionDetails;
    }

    public void setLeaveRequestDeductionDetails(List<LeaveRequestDeductionDetails> leaveRequestDeductionDetails) {
        this.leaveRequestDeductionDetails = leaveRequestDeductionDetails;
    }

    public LeaveRequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(LeaveRequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }
}
