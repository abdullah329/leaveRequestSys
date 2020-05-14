/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leave.core.entitlement;

import sa.gov.sfd.leave.infrastructure.DateOperations;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author abdullahalgarni on 21/04/2020 AD
 * @project leaveSystem
 **/
@Service
public class EntitlementServices {

    private EntitlementRepository entitlementRepository;
    private DateOperations dateOperations;

    @Autowired
    public EntitlementServices(EntitlementRepository entitlementRepository, DateOperations dateOperations) {
        this.entitlementRepository = entitlementRepository;
        this.dateOperations = dateOperations;
    }

    public List<Entitlement> loadLeaveEntitlement(EmployeeNID employeeNID){
       return entitlementRepository.findAnnualLeaveEntitlementByEmployeeNID(employeeNID);

    }

    public int insertNewEntitlement(EmployeeNID employeeNID, int eYear, int eAmmount, LocalDate eExpireDate_AH){
        return entitlementRepository.insertNewAnnualLeaveEntitlement(
                new Entitlement(employeeNID,eYear,eAmmount,
                        new EntitlementExpireDate(eExpireDate_AH,dateOperations.toGregorian(eExpireDate_AH))));

    }
}
