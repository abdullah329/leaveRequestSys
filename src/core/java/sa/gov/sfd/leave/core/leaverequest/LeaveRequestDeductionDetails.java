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

package sa.gov.sfd.leave.core.leaverequest;

import java.util.Objects;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/


public class LeaveRequestDeductionDetails {

   private final int deductionYears;
   private final int deductionNumberOfDays;

   public LeaveRequestDeductionDetails(int entitlementYears, int deductionNumberOfDays) {
      this.deductionYears = entitlementYears;
      this.deductionNumberOfDays = deductionNumberOfDays;
   }

   public int getDeductionYears() {
      return deductionYears;
   }

   public int getDeductionNumberOfDays() {
      return deductionNumberOfDays;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      LeaveRequestDeductionDetails that = (LeaveRequestDeductionDetails) o;
      return deductionYears == that.deductionYears &&
              deductionNumberOfDays == that.deductionNumberOfDays;
   }

   @Override
   public int hashCode() {
      return Objects.hash(deductionYears, deductionNumberOfDays);
   }

   @Override
   public String toString() {
      return "LeaveRequestDeduction{" +
              "deductionYears=" + deductionYears +
              ", deductionDays=" + deductionNumberOfDays +
              '}';
   }
}
