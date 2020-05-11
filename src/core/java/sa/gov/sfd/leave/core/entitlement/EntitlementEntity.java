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
public class EntitlementEntity {

    private  EntitlementId entitlementId;
    private  EmployeeNID employeeNID;
    private  int entitlementYear;
    private  int entitlementAmount;
    private  EntitlementExpireDate entitlementExpireDate;

    public EntitlementEntity(EntitlementId entitlementId, EmployeeNID employeeNID, int entitlementYear, int entitlementAmount, EntitlementExpireDate entitlementExpireDate) {
        this.entitlementId = entitlementId;
        this.employeeNID=employeeNID;
        this.entitlementYear = entitlementYear;
        this.entitlementAmount = entitlementAmount;
        this.entitlementExpireDate = entitlementExpireDate;
    }

    public EntitlementEntity(EmployeeNID employeeNID, int entitlementYear, int entitlementAmount, EntitlementExpireDate entitlementExpireDate) {
        this.employeeNID=employeeNID;
        this.entitlementYear = entitlementYear;
        this.entitlementAmount = entitlementAmount;
        this.entitlementExpireDate = entitlementExpireDate;
    }
    public EntitlementId getEntitlementId() {
        return entitlementId;
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

}
