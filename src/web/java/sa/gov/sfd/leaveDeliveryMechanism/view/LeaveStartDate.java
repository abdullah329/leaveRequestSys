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

package sa.gov.sfd.leaveDeliveryMechanism.view;

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

}
