/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaverequest.infrastructure;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sa.gov.sfd.leaverequest.core.entitlement.EntitlementInterface;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import sa.gov.sfd.leaverequest.core.entitlement.EntitlementEntity;

import java.util.List;

/**
 * @author abdullahalgarni on 24/04/2020 AD
 * @project leaveSystem
 **/
public class EntitlementRepository implements EntitlementInterface {

    private JdbcTemplate jdbcTemplate;


    //************************* SELECT Operations **************************************************
    @Override
    public List<EntitlementEntity> findAnnualLeaveEntitlementByEmployeeNID(EmployeeNID employeeNID) {
        return (List<EntitlementEntity>) jdbcTemplate.queryForObject("" +
                        "SELECT employeeNID,entitlementYear,entitlementAmount,entitlementExpireDate " +
                        "FROM AnnualLeaveEntitlement " +
                        "WHERE EmployeeNID = ?",
                new BeanPropertyRowMapper<>(EntitlementEntity.class),employeeNID.getId());
    }


    //************************* INSERT Operations **************************************************

    @Override
    public int insertNewAnnualLeaveEntitlement(EntitlementEntity annualLeaveEntitlement) {
        return jdbcTemplate.update("" +
                        "INSERT INTO AnnualLeaveEntitlement " +
                        "(entitlementId," +
                        "employeeNID, " +
                        "entitlementYear," +
                        "entitlementAmount," +
                        "entitlementExpireDate_AH," +
                        "entitlementExpireDate_AD) VALUES " +
                        "(entitlement_seq.nextval,?, ?, ?)",
                annualLeaveEntitlement.getEmployeeNID(),
                annualLeaveEntitlement.getEntitlementYear(),
                annualLeaveEntitlement.getEntitlementAmount(),
                annualLeaveEntitlement.getEntitlementExpireDate().getExpireDate_AH(),
                annualLeaveEntitlement.getEntitlementExpireDate().getExpireDate_AD());
    }
}
