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

package sa.gov.sfd.leave.core.leaverequest;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author abdullahalgarni on 15/04/2020 AD
 * @project leaveSystem
 **/
public final class LeaveStartDate {
    private final LocalDate leaveStartDate_AH; // Hijri Date
    private final LocalDate leaveStartDate_AD; // Gregorian Date

    public LeaveStartDate(LocalDate leaveStartDate_AH, LocalDate leaveStartDate_AD) {
        this.leaveStartDate_AH = leaveStartDate_AH;
        this.leaveStartDate_AD = leaveStartDate_AD;
    }

    public LocalDate getLeaveStartDate_AH() {
        return leaveStartDate_AH;
    }

    public LocalDate getLeaveStartDate_AD() {
        return leaveStartDate_AD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveStartDate that = (LeaveStartDate) o;
        return leaveStartDate_AH.equals(that.leaveStartDate_AH) &&
                leaveStartDate_AD.equals(that.leaveStartDate_AD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaveStartDate_AH, leaveStartDate_AD);
    }

    @Override
    public String toString() {
        return "annualLeaveStartDate{" +
                "leaveStartDate_HC='" + leaveStartDate_AH + '\'' +
                ", leaveStartDate_GC=" + leaveStartDate_AD +
                '}';
    }
}
