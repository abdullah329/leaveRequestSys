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

package sa.gov.sfd.leave.core.entitlement;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author abdullahalgarni on 16/04/2020 AD
 * @project leaveSystem
 **/
public class EntitlementExpireDate {

    private final  LocalDate expireDate_AH; // Hijri Date
    private final  LocalDate expireDate_AD; // Gregorian Dates

    public EntitlementExpireDate(LocalDate expireDate_AH, LocalDate expireDate_AD) {
        this.expireDate_AH = expireDate_AH;
        this.expireDate_AD = expireDate_AD;
    }

    public LocalDate getExpireDate_AH() {
        return expireDate_AH;
    }

    public LocalDate getExpireDate_AD() {
        return expireDate_AD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntitlementExpireDate that = (EntitlementExpireDate) o;
        return expireDate_AH.equals(that.expireDate_AH) &&
                expireDate_AD.equals(that.expireDate_AD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expireDate_AH, expireDate_AD);
    }

    @Override
    public String toString() {
        return "ExpireDate{" +
                "expireDate_HC='" + expireDate_AH + '\'' +
                ", expireDate_GC=" + expireDate_AD +
                '}';
    }
}
