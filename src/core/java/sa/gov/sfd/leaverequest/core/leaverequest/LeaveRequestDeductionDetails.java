/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */


package sa.gov.sfd.leaverequest.core.leaverequest;

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
