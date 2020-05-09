/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaverequest.core.entitlement;

import sa.gov.sfd.leaveapproval.core.EmployeeNID;

import java.util.List;

/**
 * @author abdullahalgarni on 24/04/2020 AD
 * @project leaveSystem
 **/
public interface EntitlementInterface {


    //************************* SELECT Operations **************************************************
    List<EntitlementEntity> findAnnualLeaveEntitlementByEmployeeNID(EmployeeNID employeeNID);


    //************************* INSERT Operations **************************************************
    int insertNewAnnualLeaveEntitlement(EntitlementEntity annualLeaveEntitlement);
}
