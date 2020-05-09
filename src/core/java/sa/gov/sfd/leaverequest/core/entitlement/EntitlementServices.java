/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaverequest.core.entitlement;

import com.google.inject.Inject;
import sa.gov.sfd.leaverequest.infrastructure.DateOperations;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;

import java.time.LocalDate;
import java.util.List;

/**
 * @author abdullahalgarni on 21/04/2020 AD
 * @project leaveSystem
 **/
public class EntitlementServices {

    private EntitlementInterface entitlementRepository;
    private DateOperations dateOperations;

    @Inject
    public EntitlementServices(EntitlementInterface entitlementRepository, DateOperations dateOperations) {
        this.entitlementRepository = entitlementRepository;
        this.dateOperations = dateOperations;
    }

    public List<EntitlementEntity> loadLeaveEntitlement(EmployeeNID employeeNID){
       return entitlementRepository.findAnnualLeaveEntitlementByEmployeeNID(employeeNID);

    }

    public int insertNewEntitlement(EmployeeNID employeeNID, int eYear, int eAmmount, LocalDate eExpireDate_AH){
        return entitlementRepository.insertNewAnnualLeaveEntitlement(
                new EntitlementEntity(employeeNID,eYear,eAmmount,
                        new EntitlementExpireDate(eExpireDate_AH,dateOperations.toGregorian(eExpireDate_AH))));

    }
}
