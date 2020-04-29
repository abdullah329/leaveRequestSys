/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveRequest.operations;

import sa.gov.sfd.leaveCore.infrastructure.calendar.DateOperations;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.*;
import sa.gov.sfd.leaveCore.model.leaveRequest.infrastructure.repository.AnnualLeaveEntitlementRepository;
import sa.gov.sfd.leaveCore.model.leaveRequest.infrastructure.repository.LeaveRequestRepository;

import java.time.LocalDate;
import java.util.*;

/**
 * @author abdullahalgarni on 21/04/2020 AD
 * @project leaveSystem
 **/
public class AnnualLeaveMethods {


    private LeaveRequestRepository leaveRequestRepository;
    private  final List<LeaveRequestTrackerEntity> allLeave;
    private AnnualLeaveEntitlementRepository annualLeaveEntitlementRepository;
    private AnnualLeaveMethods annualLeaveUsed;
    private  final List<AnnualLeaveEntitlement> leaveEntitlement;
    private  final List<AnnualLeaveEntitlement> validAnnualLeaveEntitlementList;
    private  final EmployeeNID employeeNID;
    private DateOperations dateOperations;


    //Constructor
    public AnnualLeaveMethods(EmployeeNID employeeNID){
        this.employeeNID = employeeNID;
        leaveEntitlement =fetchAllAnnualLeaveEntitlement();
        validAnnualLeaveEntitlementList = sortListOfAllVailAndNotUsedEntitlementPerYear();
        allLeave = loadAllAnnualLeaveUsedByEmployeeNID();
    }
    public List<LeaveRequestTrackerEntity> loadAllAnnualLeaveUsedByEmployeeNID() {
        List<LeaveRequestTrackerEntity> listLeave =  this.leaveRequestRepository.findAllLeaveRequestNOTDeclinedByEmployeeNID(employeeNID);
        //sort the list by year
        listLeave.sort(Comparator.comparing(x -> x.getLeaveRequestDetailsInfo().getLeaveStartDate().getLeaveStartDate_AH()));

        return listLeave;
    }


    public int totalAnnualLeaveUsed() {

        int sumAllLeaveDetails = 0;
        for (LeaveRequestTrackerEntity leave : allLeave) {
            for (int i = 0; i <= leave.getLeaveRequestDeductionDetails().size(); i++) {
                    sumAllLeaveDetails += leave.getLeaveRequestDeductionDetails().get(i).getDeductionNumberOfDays();
            }
        }
        return sumAllLeaveDetails;
    }


    public LocalDate lastLeaveRequestDate(){

        return allLeave.get(allLeave.size()).getLeaveRequestDetailsInfo().getLeaveStartDate().getLeaveStartDate_AH();
    }

    public int totalAnnualLeaveUsedPerYear(int year) {

        int sumAllLeaveDetails = 0;
        for (LeaveRequestTrackerEntity leave : allLeave) {
            for (int i = 0; i <= leave.getLeaveRequestDeductionDetails().size(); i++) {
                if (leave.getLeaveRequestDeductionDetails().get(i).getDeductionYears() == year) {
                    sumAllLeaveDetails += leave.getLeaveRequestDeductionDetails().get(i).getDeductionNumberOfDays();
                }
            }
        }
        return sumAllLeaveDetails;
    }

    public Long insetNewLeaveRequestInToRepository(LeaveRequestInfo newLeaveRequestInfo){

        return  leaveRequestRepository.insertNew(newLeaveRequestInfo,new LeaveRequestStatus("P"));
    }

    public void insetNewLeaveDeductionInToRepository(List<LeaveRequestDeductionDetails> newLeaveRequestDeduction, LeaveId leavetId){

        for(LeaveRequestDeductionDetails leaveDeduction : newLeaveRequestDeduction) {
            leaveRequestRepository.insertNewLeaveDeductionDetails(leaveDeduction,leavetId);
        }

    }
    public Long addNewLeaveRequest(LeaveRequestInfo newLeaveRequestInfo){

        Long newleaveId = null;
      if(newLeaveRequestInfo.getNumberOfDaysLeave() >= totalValidAnnualLeaveEntitlement()){
             newleaveId = insetNewLeaveRequestInToRepository(newLeaveRequestInfo);
            insetNewLeaveDeductionInToRepository(distributeLeaveRequestOverYearsEntitlement(newLeaveRequestInfo.getNumberOfDaysLeave()),new LeaveId(newleaveId));

        }

        return newleaveId;
    }


    public List<LeaveRequestDeductionDetails> distributeLeaveRequestOverYearsEntitlement(int numberOfDaysLeave){

        int newNumOfDays = numberOfDaysLeave;
       List<LeaveRequestDeductionDetails> newDistributionList = new ArrayList<>();

       for(int i=0;i <= getValidAnnualLeaveEntitlementList().size(); i++) {
           LeaveRequestDeductionDetails newDeduction;
           if (getValidAnnualLeaveEntitlementList().get(i).getEntitlementAmount() < newNumOfDays) {
               newNumOfDays = newNumOfDays - getValidAnnualLeaveEntitlementList().get(i).getEntitlementAmount();
                newDeduction =
                       new LeaveRequestDeductionDetails(getValidAnnualLeaveEntitlementList().get(i).getEntitlementYear(),
                               getValidAnnualLeaveEntitlementList().get(i).getEntitlementAmount());
           }
           else{
                newDeduction =
                       new LeaveRequestDeductionDetails(getValidAnnualLeaveEntitlementList().get(i).getEntitlementYear(),
                               newNumOfDays);

           }

           newDistributionList.add(newDeduction);
       }
       return newDistributionList;

    }


    public List<AnnualLeaveEntitlement> fetchAllAnnualLeaveEntitlement(){

        return this.annualLeaveEntitlementRepository.findAnnualLeaveEntitlementByEmployeeNID(employeeNID);
    }

    public int totalValidAnnualLeaveEntitlement() {

        int creditSum=0;
        for (AnnualLeaveEntitlement credit : validAnnualLeaveEntitlementList) {
            creditSum += credit.getEntitlementAmount();
        }

        return creditSum;
    }


    public  List<AnnualLeaveEntitlement> sortListOfAllVailAndNotUsedEntitlementPerYear() {
        List<AnnualLeaveEntitlement> validList = new ArrayList<>();
        for (AnnualLeaveEntitlement credit : leaveEntitlement) {
            if(credit.getEntitlementExpireDate().getExpireDate_AH().compareTo(dateOperations.nowHijri())>0) {
                int year = credit.getEntitlementYear();
                int validCredit = credit.getEntitlementAmount() - totalAnnualLeaveUsedPerYear(year);
                validList.add(new AnnualLeaveEntitlement(employeeNID,year,validCredit,credit.getEntitlementExpireDate()));
            }
        }

        //sort the list by year
        validList.sort(Comparator.comparing(AnnualLeaveEntitlement::getEntitlementYear));

        return validList;
    }


    public LeaveRequestRepository getLeaveRequestRepository() {
        return leaveRequestRepository;
    }

    public  List<LeaveRequestTrackerEntity> getAllLeave() {
        return allLeave;
    }

    public AnnualLeaveEntitlementRepository getAnnualLeaveEntitlementRepository() {
        return annualLeaveEntitlementRepository;
    }

    public AnnualLeaveMethods getAnnualLeaveUsed() {
        return annualLeaveUsed;
    }

    public  List<AnnualLeaveEntitlement> getLeaveEntitlement() {
        return leaveEntitlement;
    }

    public  List<AnnualLeaveEntitlement> getValidAnnualLeaveEntitlementList() {
        return validAnnualLeaveEntitlementList;
    }


}
