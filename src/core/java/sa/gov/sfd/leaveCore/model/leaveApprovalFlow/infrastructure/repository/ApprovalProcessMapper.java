/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveApprovalFlow.infrastructure.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.ProcessFlowId;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.ApproverRoles;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.ApproverTeamEntity;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.LeaveApprovalProcessesFlowEntity;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abdullahalgarni on 22/04/2020 AD
 * @project leaveSystem
 **/


public final class ApprovalProcessMapper implements ResultSetExtractor<List<LeaveApprovalProcessesFlowEntity>> {

    private static List<LeaveApprovalProcessesFlowEntity> leaveApprovalProcessesEntity =null;


    @Override
    public List<LeaveApprovalProcessesFlowEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {

        int processId=0;
        LeaveApprovalProcessesFlowEntity leaveApprovalProcesses = null;
        List<ApproverTeamEntity> approverTeams= null;
        while (rs.next()) {

            if (processId==0 || processId !=rs.getInt("processId")) {
                if(processId!=0 && leaveApprovalProcesses != null){
                    leaveApprovalProcesses.setApproverAndRols(approverTeams);
                    this.leaveApprovalProcessesEntity.add(leaveApprovalProcesses);
                }
                leaveApprovalProcesses = new LeaveApprovalProcessesFlowEntity();
                approverTeams= new ArrayList<>();

                LeaveApprovalProcessesMapper(rs,leaveApprovalProcesses);
                processId= leaveApprovalProcesses.getProcessId().getId();

            }
            approverTeams.add(approverTeamsMapper(rs));
        }

        return this.leaveApprovalProcessesEntity;
    }

    public LeaveApprovalProcessesFlowEntity LeaveApprovalProcessesMapper(ResultSet rs, LeaveApprovalProcessesFlowEntity processEntity) throws SQLException {
        processEntity = new LeaveApprovalProcessesFlowEntity();
        processEntity.setProcessId(new ProcessFlowId(rs.getInt("processId")));
        processEntity.setProcessId(new ProcessFlowId(rs.getInt("approvalScenarioId")));
        processEntity.setProcessId(new ProcessFlowId(rs.getInt("processStepNumber")));




        return processEntity;
    }

    public ApproverTeamEntity approverTeamsMapper (ResultSet rs) throws SQLException {
        return new ApproverTeamEntity(approverTeamId, new EmployeeNID(rs.getLong("employeeNID")),
                        new ApproverRoles(rs.getInt("approveRole"),rs.getInt("declineRole"),rs.getInt("viewRole"),
                                rs.getInt("confirmRole")));

    }
}


