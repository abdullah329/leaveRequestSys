package sa.gov.sfd.leave.actions;

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

    private LeaveRequestRepository leaveRequestRepository;


    public List<LeaveRequestEntity> loadAllLeaveUsedByEmployeeNID(EmployeeNID employeeNID) {
        List<LeaveRequestEntity> listLeave =  this.leaveRequestRepository.findAllLeaveRequestNOTDeclinedByEmployeeNID(employeeNID);
        //sort the list by year
        listLeave.sort(Comparator.comparing(x -> x.getLeaveRequestDetailsInfo().getLeaveStartDate().getLeaveStartDate_AH()));

        return listLeave;
    }

    public List<LeaveRequestEntity> loadAllLeavePendingByEmployeeNED(EmployeeNID employeeNID) {
        List<LeaveRequestEntity> listLeave =  this.leaveRequestRepository.findAllLeaveRequestNOTDeclinedByEmployeeNID(employeeNID);
        //sort the list by year
        listLeave.sort(Comparator.comparing(x -> x.getLeaveRequestDetailsInfo().getLeaveStartDate().getLeaveStartDate_AH()));

        return listLeave;
    }

}
