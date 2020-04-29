/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.actions.leaveRequest;

import sa.gov.sfd.leaveCore.infrastructure.calendar.DateOperations;
import sa.gov.sfd.leaveCore.model.leaveRequest.LeaveRequestService;

/**
 * @author abdullahalgarni on 21/04/2020 AD
 * @project leaveSystem
 **/
public class CheckingLeaveEligibility {

    private LeaveRequestService leaveRequestService;
    private DateOperations dateOperations;


    public String checkingEligibility(int leaveDaysRequired, String currentLeaveRequestStartDate){

        return leaveRequestService.checkingPolicy(leaveDaysRequired,dateOperations.formateHijri(currentLeaveRequestStartDate));
    }
}
