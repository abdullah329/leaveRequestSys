/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package sa.gov.sfd.leaveCore.model.leaveRequest.dataModel;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/

//DataBase Entity
public class LeaveRequestTrackerEntity {

    private LeaveId leaveId;
    private LeaveRequestInfo leaveRequestDetailsInfo;
    private Timestamp requestTimeStamp;
    private LeaveRequestStatus requestStatus;
    private List<LeaveRequestDeductionDetails> leaveRequestDeductionDetails; // ex : for requesting 15 days leave => if entitlement in year 2018 is 8 and in year 2019 is 15 , then system deducts the 8 days from 2018 and the rest from 2019



   /* public LeaveRequestTrackerEntity(LeavetId leaveId, EmployeeNID employeeNID, LeaveStartDate leaveStartDate, Timestamp requestTimeStamp, LeaveRequestStatus status, List<LeaveRequestDeductionDetails> LeaveDetails) {
        this.leaveId = leaveId;
        this.employeeNID = employeeNID;
        this.leaveStartDate = leaveStartDate;
        this.requestTimeStamp = requestTimeStamp;
        this.requestStatus = status;
        this.LeaveDetails = LeaveDetails;
    }*/


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

    public Timestamp getRequestTimeStamp() {
        return requestTimeStamp;
    }

    public void setRequestTimeStamp(Timestamp requestTimeStamp) {
        this.requestTimeStamp = requestTimeStamp;
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
