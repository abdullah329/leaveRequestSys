/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveapproval.core;

import java.time.LocalDate;

import java.util.Objects;

/**
 * @author abdullahalgarni on 16/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveApprovalTransDate {

    private final LocalDate leaveAppTransDate_AH;
    private final LocalDate leaveAppTransDate_AD;

    public LeaveApprovalTransDate(LocalDate leaveAppTransDate_AH, LocalDate leaveAppTransDate_AD) {
        this.leaveAppTransDate_AH = Objects.requireNonNull(leaveAppTransDate_AH);
        this.leaveAppTransDate_AD = Objects.requireNonNull(leaveAppTransDate_AD);
    }

    public LocalDate getLeaveAppTransDate_AH() {
        return leaveAppTransDate_AH;
    }

    public LocalDate getLeaveAppTransDate_AD() {
        return leaveAppTransDate_AD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveApprovalTransDate that = (LeaveApprovalTransDate) o;
        return leaveAppTransDate_AH.equals(that.leaveAppTransDate_AH) &&
                leaveAppTransDate_AD.equals(that.leaveAppTransDate_AD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaveAppTransDate_AH, leaveAppTransDate_AD);
    }

    @Override
    public String toString() {
        return "LeaveApprovalTransDate{" +
                "leaveAppTransDate_AH=" + leaveAppTransDate_AH +
                ", leaveAppTransDate_AD=" + leaveAppTransDate_AD +
                '}';
    }
}
