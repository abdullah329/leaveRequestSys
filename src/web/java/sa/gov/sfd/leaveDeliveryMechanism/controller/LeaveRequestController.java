package sa.gov.sfd.leaveDeliveryMechanism.controller;


import com.google.inject.Inject;
import org.springframework.web.bind.annotation.*;
import sa.gov.sfd.leave.actions.ApplyForLeaveRequest;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;
import sa.gov.sfd.leaveDeliveryMechanism.view.LeaveRequestViewModel;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class LeaveRequestController {

    @Inject private ApplyForLeaveRequest newLeave;

    @PostMapping("save-leave-request")
    public boolean addNewLeaveRequest(@RequestBody LeaveRequestViewModel leaveRequestDTO){
        return newLeave.apply(leaveRequestDTO.getEmployeeNID(), LocalDate.parse(leaveRequestDTO.getLeaveStartDate_AH()),leaveRequestDTO.getLeaveDayRequired());
    }

     //todo another functions
}
