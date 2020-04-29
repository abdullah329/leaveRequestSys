/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveRequest.operations;

import sa.gov.sfd.leaveCore.infrastructure.calendar.DateOperations;

import java.time.LocalDate;

/**
 * @author abdullahalgarni on 28/04/2020 AD
 * @project leaveSystem
 **/
public class LeaveRequestPolicy {

    //todo : write here a code that contain a policy for leave request , such as max leave days allowed .... etc.

    private final static int maxLeaveDays = 90;
    private final static int minLeaveDays = 1;

    private final static int numberOfDaysBetweenEachLeave = 5; // example

    private DateOperations dateOperations;


    public String checkingPolicy(int leaveDaysRequired, LocalDate lastLeaveRequestConfirmed, LocalDate currentLeaveRequestStartDate){

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

    public static int getMaxLeaveDays() {
        return maxLeaveDays;
    }

    public static int getMinLeaveDays() {
        return minLeaveDays;
    }

    public static int getNumberOfDaysBetweenEachLeave() {
        return numberOfDaysBetweenEachLeave;
    }
}
