package sa.gov.sfd.leaveDeliveryMechanism.controller;


import org.springframework.web.bind.annotation.*;
import sa.gov.sfd.leaveCore.actions.leaveRequest.AddNewLeaveRequest;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.LeaveRequestTrackerEntity;
import sa.gov.sfd.leaveDeliveryMechanism.view.LeaveRequestViewModel;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class LeaveRequestController {

    private AddNewLeaveRequest addNewLeaveRequest = new AddNewLeaveRequest();

    @PostMapping("save-leave-request")
    public boolean addNewLeaveRequest(@RequestBody LeaveRequestViewModel leaveRequestDTO){
        return addNewLeaveRequest.addNewLeave(
                new EmployeeNID(leaveRequestDTO.getEmployeeNID()),leaveRequestDTO.getLeaveStartDate_AH(),leaveRequestDTO.getLeaveDayRequired());
    }

     //todo another functions
}
