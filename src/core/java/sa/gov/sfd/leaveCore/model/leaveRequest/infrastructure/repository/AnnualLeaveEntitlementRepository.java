/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveRequest.infrastructure.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.AnnualLeaveEntitlement;

import java.util.List;

/**
 * @author abdullahalgarni on 24/04/2020 AD
 * @project leaveSystem
 **/
public class AnnualLeaveEntitlementRepository {

    private JdbcTemplate jdbcTemplate;


    //************************* SELECT Operations **************************************************
    public List<AnnualLeaveEntitlement> findAnnualLeaveEntitlementByEmployeeNID(EmployeeNID employeeNID) {
        return (List<AnnualLeaveEntitlement>) jdbcTemplate.queryForObject("" +
                        "SELECT employeeNID,entitlementYear,entitlementAmount,entitlementExpireDate " +
                        "FROM AnnualLeaveEntitlement " +
                        "WHERE EmployeeNID = ?",
                new BeanPropertyRowMapper<>(AnnualLeaveEntitlement.class),employeeNID.getId());
    }


    //************************* INSERT Operations **************************************************


    public int insertNewAnnualLeaveEntitlement(AnnualLeaveEntitlement annualLeaveEntitlement) {
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
