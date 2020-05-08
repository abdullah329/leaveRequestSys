/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveapproval.infrastructure;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import sa.gov.sfd.leaveapproval.core.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abdullahalgarni on 22/04/2020 AD
 * @project leaveSystem
 **/


public final class ApprovalProcessMapper implements ResultSetExtractor<List<LeaveApprovalProcessesEntity>> {

    private static List<LeaveApprovalProcessesEntity> leaveApprovalProcessesEntity =null;


    @Override
    public List<LeaveApprovalProcessesEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {

        int processId=0;
        LeaveApprovalProcessesEntity leaveApprovalProcesses = null;
        List<ApproverTeamEntity> approverTeams= null;
        while (rs.next()) {

            if (processId==0 || processId !=rs.getInt("processId")) {
                if(processId!=0 && leaveApprovalProcesses != null){
                    leaveApprovalProcesses.setApproverAndRols(approverTeams);
                    this.leaveApprovalProcessesEntity.add(leaveApprovalProcesses);
                }
                leaveApprovalProcesses = new LeaveApprovalProcessesEntity();
                approverTeams= new ArrayList<>();

                LeaveApprovalProcessesMapper(rs,leaveApprovalProcesses);
                processId= leaveApprovalProcesses.getProcessId().getId();

            }
            approverTeams.add(approverTeamsMapper(rs));
        }

        return this.leaveApprovalProcessesEntity;
    }

    public LeaveApprovalProcessesEntity LeaveApprovalProcessesMapper(ResultSet rs, LeaveApprovalProcessesEntity processEntity) throws SQLException {
        processEntity = new LeaveApprovalProcessesEntity();
        processEntity.setProcessId(new ProcessFlowId(rs.getInt("processId")));
        processEntity.setProcessId(new ProcessFlowId(rs.getInt("approvalScenarioId")));
        processEntity.setProcessId(new ProcessFlowId(rs.getInt("processStepNumber")));




        return processEntity;
    }

    public ApproverTeamEntity approverTeamsMapper (ResultSet rs) throws SQLException {
        return new ApproverTeamEntity(new ApproverTeamId(rs.getInt("approverTeamId")), new EmployeeNID(rs.getLong("employeeNID")),
                        new ApproverRoles(rs.getInt("approveRole"),rs.getInt("declineRole"),rs.getInt("viewRole"),
                                rs.getInt("confirmRole")));

    }
}


