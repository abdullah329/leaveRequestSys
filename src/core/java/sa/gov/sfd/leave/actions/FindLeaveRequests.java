package sa.gov.sfd.leave.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leave.core.leaverequest.LeaveRequestService;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import sa.gov.sfd.leave.core.leaverequest.LeaveRequestEntity;
import sa.gov.sfd.leave.infrastructure.LeaveRequestRepository;

import java.util.Comparator;
import java.util.List;

/**
 * @author abdullahalgarni on 06/05/2020 AD
 * @project leaveSys
 **/
public class FindLeaveRequests {

    private LeaveRequestService leaveRequestService;

    @Inject
    public FindLeaveRequests(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }



    public List<LeaveRequestEntity> loadAllLeaveTaken(EmployeeNID employeeNID) {
        List<LeaveRequestEntity> listLeave =  this.leaveRequestService.loadLeaveTaken(employeeNID);
        //sort the list by date
        listLeave.sort(Comparator.comparing(x -> x.getLeaveRequestDetailsInfo().getLeaveStartDate().getLeaveStartDate_AH()));

        return listLeave;
    }

    public List<LeaveRequestEntity> loadAllLeaveNotConfirmed(EmployeeNID employeeNID) {
        List<LeaveRequestEntity> listLeave =  this.leaveRequestService.loadLeaveTakenNotConfirmed(employeeNID);
        //sort the list by year
        listLeave.sort(Comparator.comparing(x -> x.getLeaveRequestDetailsInfo().getLeaveStartDate().getLeaveStartDate_AH()));

        return listLeave;
    }

}
