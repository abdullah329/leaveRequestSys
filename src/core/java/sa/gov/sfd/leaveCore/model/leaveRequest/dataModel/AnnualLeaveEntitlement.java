/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveRequest.dataModel;

import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;

import java.util.Objects;

/**
 * @author abdullahalgarni on 21/04/2020 AD
 * @project leaveSystem
 **/
public class AnnualLeaveEntitlement {

    private final EmployeeNID employeeNID;
    private final int entitlementYear;
    private final int entitlementAmount;
    private final LeaveEntitlementExpireDate entitlementExpireDate;

    public AnnualLeaveEntitlement(EmployeeNID employeeNID,int entitlementYear, int entitlementAmount, LeaveEntitlementExpireDate entitlementExpireDate) {
        this.employeeNID=employeeNID;
        this.entitlementYear = entitlementYear;
        this.entitlementAmount = entitlementAmount;
        this.entitlementExpireDate = entitlementExpireDate;
    }

    public EmployeeNID getEmployeeNID() {
        return employeeNID;
    }

    public int getEntitlementYear() {
        return entitlementYear;
    }

    public int getEntitlementAmount() {
        return entitlementAmount;
    }

    public LeaveEntitlementExpireDate getEntitlementExpireDate() {
        return entitlementExpireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnualLeaveEntitlement that = (AnnualLeaveEntitlement) o;
        return entitlementYear == that.entitlementYear &&
                entitlementAmount == that.entitlementAmount &&
                employeeNID.equals(that.employeeNID) &&
                entitlementExpireDate.equals(that.entitlementExpireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNID, entitlementYear, entitlementAmount, entitlementExpireDate);
    }

    @Override
    public String toString() {
        return "AnnualLeaveEntitlement{" +
                "employeeNID=" + employeeNID +
                ", entitlementYear=" + entitlementYear +
                ", entitlementAmount=" + entitlementAmount +
                ", entitlementExpireDate=" + entitlementExpireDate +
                '}';
    }
}
