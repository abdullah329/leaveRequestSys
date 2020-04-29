package sa.gov.sfd.leaveCore.model.leaveRequest;

import sa.gov.sfd.leaveCore.infrastructure.calendar.DateOperations;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveRequest.infrastructure.repository.LeaveRequestRepository;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.*;
import sa.gov.sfd.leaveCore.model.leaveRequest.operations.AnnualLeaveMethods;
import sa.gov.sfd.leaveCore.model.leaveRequest.operations.LeaveRequestPolicy;

import java.time.LocalDate;
import java.util.List;

/**
 * @author abdullahalgarni on 14/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveRequestService {

    private LeaveRequestRepository leaveRequestRepository;
    private AnnualLeaveMethods annualLeaveMethods;
    private LeaveRequestPolicy leaveRequestPolicy;
    private DateOperations dateOperations;

    private EmployeeNID employeeNID;

    public LeaveRequestService(EmployeeNID employeeNID){
        this.employeeNID= employeeNID;

        annualLeaveMethods = new AnnualLeaveMethods(employeeNID);
    }

    public List<AnnualLeaveEntitlement> fetchAllAnnualLeaveEntitlementByEmployeeNID(){

        return annualLeaveMethods.fetchAllAnnualLeaveEntitlement();
    }



    public void updateLeaveStatus(LeaveId leaveRequestId , LeaveRequestStatus newLeaveStatus){
        leaveRequestRepository.updateLeaveStatus(leaveRequestId,newLeaveStatus);
    }

    public String checkingPolicy(int leaveDaysRequired, LocalDate currentLeaveRequestStartDate){


        return leaveRequestPolicy.checkingPolicy(leaveDaysRequired,annualLeaveMethods.lastLeaveRequestDate(),currentLeaveRequestStartDate);
    }

    public long addNewLeaveRequest(LocalDate leaveStartDate_AH,
                                     int numberOfDaysLeave){

        LeaveStartDate startDate = new LeaveStartDate(leaveStartDate_AH, dateOperations.toGregorian(leaveStartDate_AH));
        long newLeaveId = annualLeaveMethods.addNewLeaveRequest(new LeaveRequestInfo(employeeNID,startDate,numberOfDaysLeave));

        return newLeaveId;


    }


}
