/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leave.core.entitlement;

import sa.gov.sfd.leaveapproval.core.EmployeeNID;

import java.util.Objects;

/**
 * @author abdullahalgarni on 21/04/2020 AD
 * @project leaveSystem
 **/
public class Entitlement {


    private final EmployeeNID employeeNID;
    private final int entitlementYear;
    private final int entitlementAmount;
    private final EntitlementExpireDate entitlementExpireDate;



    public Entitlement(EmployeeNID employeeNID, int entitlementYear, int entitlementAmount, EntitlementExpireDate entitlementExpireDate) {
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

    public EntitlementExpireDate getEntitlementExpireDate() {
        return entitlementExpireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entitlement that = (Entitlement) o;
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
        return "Entitlement{" +
                "employeeNID=" + employeeNID +
                ", entitlementYear=" + entitlementYear +
                ", entitlementAmount=" + entitlementAmount +
                ", entitlementExpireDate=" + entitlementExpireDate +
                '}';
    }
}
