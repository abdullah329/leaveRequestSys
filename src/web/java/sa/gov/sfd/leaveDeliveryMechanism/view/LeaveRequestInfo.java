/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveDeliveryMechanism.view;

import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.LeaveStartDate;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/

//value object
public class LeaveRequestInfo {

    private final Long employeeNID;
    private final LeaveStartDate leaveStartDate; // Hijri & Gregorian
    private final int numberOfDaysLeave;


    public LeaveRequestInfo(Long employeeNID, LeaveStartDate leaveStartDate, int numberOfDayLeave) {
        this.employeeNID = employeeNID;
        this.leaveStartDate = leaveStartDate;
        this.numberOfDaysLeave = numberOfDayLeave;
    }

    public Long getEmployeeNID() {
        return employeeNID;
    }

    public LeaveStartDate getLeaveStartDate() {
        return leaveStartDate;
    }

    public int getNumberOfDaysLeave() {
        return numberOfDaysLeave;
    }

}
