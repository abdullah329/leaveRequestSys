/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaverequest.core.leaverequest;

import sa.gov.sfd.leaveapproval.core.EmployeeNID;

import java.util.Objects;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/

//value object
public class LeaveRequestInfo {

    private final EmployeeNID employeeNID;
    private final LeaveStartDate leaveStartDate; // Hijri & Gregorian
    private final int numberOfDaysLeave;


    public LeaveRequestInfo(EmployeeNID employeeNID, LeaveStartDate leaveStartDate, int numberOfDayLeave) {
        this.employeeNID = employeeNID;
        this.leaveStartDate = leaveStartDate;
        this.numberOfDaysLeave = numberOfDayLeave;
    }

    public EmployeeNID getEmployeeNID() {
        return employeeNID;
    }

    public LeaveStartDate getLeaveStartDate() {
        return leaveStartDate;
    }

    public int getNumberOfDaysLeave() {
        return numberOfDaysLeave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveRequestInfo that = (LeaveRequestInfo) o;
        return numberOfDaysLeave == that.numberOfDaysLeave &&
                employeeNID.equals(that.employeeNID) &&
                leaveStartDate.equals(that.leaveStartDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNID, leaveStartDate, numberOfDaysLeave);
    }

    @Override
    public String toString() {
        return "LeaveRequestDetailsInfo{" +
                "employeeNID=" + employeeNID +
                ", leaveStartDate=" + leaveStartDate +
                ", numberOfDayLeave=" + numberOfDaysLeave +
                '}';
    }
}
