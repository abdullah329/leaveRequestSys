package sa.gov.sfd.leave.core.balance;

import sa.gov.sfd.leave.core.entitlement.Entitlement;
import sa.gov.sfd.leave.core.entitlement.EntitlementServices;
import sa.gov.sfd.leave.core.leaverequest.LeaveRequestDeductionDetails;
import sa.gov.sfd.leave.core.leaverequest.LeaveRequestService;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author abdullahalgarni on 07/05/2020 AD
 * @project leaveSys
 **/
@Service
public class BalanceServices {

    private EntitlementServices entitlementServices;
    private LeaveRequestService leaveRequestService;

    @Autowired
    public BalanceServices(EntitlementServices entitlementServices, LeaveRequestService leaveRequestService) {
        this.entitlementServices = entitlementServices;
        this.leaveRequestService = leaveRequestService;
    }

    public List<LeaveBalances> calculateLeaveEntitlementRemaining(EmployeeNID employeeNID) {


        List<Entitlement> entitlementPerYear = entitlementServices.loadLeaveEntitlement(employeeNID);

        List<LeaveRequestDeductionDetails> daysTakenPerYear = leaveRequestService.loadDaysTakenPerYear(employeeNID);

        List<LeaveBalances> leaveBalances = new ArrayList<>();

        for(Entitlement entitled : entitlementPerYear){
            int totalTaken=0;
            for(LeaveRequestDeductionDetails daysTaken : daysTakenPerYear){
                if(entitled.getEntitlementYear() == daysTaken.getDeductionYears()) {
                    totalTaken += daysTaken.getDeductionNumberOfDays();
                }
            }
            int entitlementRemaining = entitled.getEntitlementAmount() - totalTaken;


            leaveBalances.add(new LeaveBalances(entitled.getEntitlementYear(),entitled.getEntitlementAmount(),totalTaken,entitlementRemaining));


        }
        // sort
        leaveBalances.sort(Comparator.comparing(LeaveBalances :: getEntitledYears));
        return leaveBalances;

    }

    public int totalBalance(EmployeeNID employeeNID){
        int balance=0;
        for(LeaveBalances lb : calculateLeaveEntitlementRemaining(employeeNID)){
            balance += lb.getBalance();
        }

        return balance;
    }

}
