package sa.gov.sfd.leave.core.leaverequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sa.gov.sfd.leave.core.balance.BalanceServices;
import sa.gov.sfd.leave.core.balance.LeaveBalances;
import sa.gov.sfd.leave.infrastructure.DateOperations;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/
@Service
public class LeaveRequestService {

    private LeaveRequestRepository leaveRequestRepository;
    private BalanceServices balanceServices;
    private DateOperations dateOperations;

     @Autowired
     public LeaveRequestService(LeaveRequestRepository leaveRequestRepository, BalanceServices balanceServices, DateOperations dateOperations) {
        this.leaveRequestRepository = leaveRequestRepository;
         this.balanceServices = balanceServices;
         this.dateOperations = dateOperations;

     }


     public List<LeaveRequestDeductionDetails> loadDaysTakenPerYear(EmployeeNID employeeNID){
        List<LeaveRequestEntity> leaveRequests = leaveRequestRepository.findAllLeaveRequestNOTDeclinedByEmployeeNID(employeeNID);
        List<LeaveRequestDeductionDetails> daysTakenPerYear = new ArrayList<>();

        for(LeaveRequestEntity lr : leaveRequests){

            daysTakenPerYear.addAll(lr.getLeaveRequestDeductionDetails());
        }
        return daysTakenPerYear;
    }

    public List<LeaveRequestEntity> loadLeaveTakenNotConfirmed(EmployeeNID employeeNID){
       return leaveRequestRepository.findAllLeaveRequestPendingByEmployeeNID(employeeNID);

    }

    public List<LeaveRequestEntity> loadLeaveTaken(EmployeeNID employeeNID){
        return leaveRequestRepository.findAllLeaveRequestByEmployeeNID(employeeNID);
    }


    public void updateLeaveStatus(LeaveId leaveRequestId , LeaveRequestStatus newLeaveStatus){
        leaveRequestRepository.updateLeaveStatus(leaveRequestId,newLeaveStatus);
    }



    public long addNewLeaveRequest(EmployeeNID employeeNID, LocalDate leaveStartDate_AH,
                                     int daysRequested){

        sa.gov.sfd.leave.infrastructure.LeaveRequestRepository dao = new sa.gov.sfd.leave.infrastructure.LeaveRequestRepository();

        LeaveStartDate startDate = new LeaveStartDate(leaveStartDate_AH, dateOperations.toGregorian(leaveStartDate_AH));

        LeaveRequestInfo newLeaveRequestInfo = new LeaveRequestInfo(employeeNID,startDate,daysRequested);
        Long newleaveId = null;
        if(newLeaveRequestInfo.getNumberOfDaysLeave() >= this.balanceServices.totalBalance(newLeaveRequestInfo.getEmployeeNID())){
            newleaveId = dao.insertNew(newLeaveRequestInfo,new LeaveRequestStatus("P"));
            if(newleaveId != null && newleaveId>0){
                int daysRequestedRemaining =daysRequested;
                int daysToBeTaken = 0;
                for(LeaveBalances lb : this.balanceServices.calculateLeaveEntitlementRemaining(employeeNID)){
                    if(daysRequestedRemaining ==0){
                        break;
                    }
                   if(lb.getBalance() < daysRequestedRemaining ){
                       daysRequestedRemaining = daysRequested - lb.getBalance();
                       daysToBeTaken = lb.getBalance();
                   }else{
                       daysToBeTaken = daysRequestedRemaining;
                       daysRequestedRemaining=0;
                   }

                    dao.insertNewLeaveDeductionDetails(new LeaveRequestDeductionDetails(lb.getEntitledYears(),daysToBeTaken),new LeaveId(newleaveId));
                }

            }

        }

        return newleaveId;

    }




    public String checkingPolicy(int leaveDaysRequired, LocalDate lastLeaveRequestConfirmed, LocalDate currentLeaveRequestStartDate){

        int maxLeaveDays = 90;
        int minLeaveDays = 1;
        int numberOfDaysBetweenEachLeave = 5;


        if(leaveDaysRequired > maxLeaveDays){
            return "exceed maximum";
        }
        if(leaveDaysRequired < minLeaveDays){
            return "less than minimum";
        }
        if(dateOperations.daysBetween2Dates(currentLeaveRequestStartDate,lastLeaveRequestConfirmed)>numberOfDaysBetweenEachLeave){
            return "exceed maximum";
        }
        return "Done";
    }



}
