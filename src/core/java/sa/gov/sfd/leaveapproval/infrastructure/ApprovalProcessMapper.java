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


public final class ApprovalProcessMapper implements ResultSetExtractor<List<ApprovalProcessesEntity>> {

    private static List<ApprovalProcessesEntity> leaveApprovalProcessesEntity =null;


    @Override
    public List<ApprovalProcessesEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {

        int processId=0;
        ApprovalProcessesEntity leaveApprovalProcesses = null;
        List<ApproverTeamEntity> approverTeams= null;
        while (rs.next()) {

            if (processId==0 || processId !=rs.getInt("processId")) {
                if(processId!=0 && leaveApprovalProcesses != null){
                    leaveApprovalProcesses.setApproverAndRols(approverTeams);
                    this.leaveApprovalProcessesEntity.add(leaveApprovalProcesses);
                }
                leaveApprovalProcesses = new ApprovalProcessesEntity();
                approverTeams= new ArrayList<>();

                LeaveApprovalProcessesMapper(rs,leaveApprovalProcesses);
                processId= leaveApprovalProcesses.getProcessId().getId();

            }
            approverTeams.add(approverTeamsMapper(rs));
        }

        return this.leaveApprovalProcessesEntity;
    }

    public ApprovalProcessesEntity LeaveApprovalProcessesMapper(ResultSet rs, ApprovalProcessesEntity processEntity) throws SQLException {
        processEntity = new ApprovalProcessesEntity();
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


