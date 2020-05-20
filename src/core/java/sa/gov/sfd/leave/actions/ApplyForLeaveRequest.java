package sa.gov.sfd.leave.actions;

import com.google.inject.Inject;
import sa.gov.sfd.leave.core.leaverequest.LeaveRequestService;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

/**
 * @author abdullahalgarni on 06/05/2020 AD
 * @project leaveSys
 **/

@Service
public class ApplyForLeaveRequest {

    private LeaveRequestService leaveRequestService;

    @Autowired
    public ApplyForLeaveRequest(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    public boolean apply(Long employeeNID,LocalDate leaveStartDate_AH,
                      int numberOfDaysLeave){
        long leaveId = leaveRequestService.addNewLeaveRequest(new EmployeeNID(employeeNID),leaveStartDate_AH,numberOfDaysLeave);

        if(leaveId>0){
            //TODO send a messange to leaveapproval to (start) apply for new leave approval process
            return true;
        }
        else
        {
            return false;
        }
    }

}
