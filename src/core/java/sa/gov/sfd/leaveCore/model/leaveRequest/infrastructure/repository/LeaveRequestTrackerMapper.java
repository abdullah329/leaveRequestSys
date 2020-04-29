/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leaveCore.model.leaveRequest.infrastructure.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import sa.gov.sfd.leaveCore.model.leaveApprovalFlow.dataModel.EmployeeNID;
import sa.gov.sfd.leaveCore.model.leaveRequest.dataModel.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abdullahalgarni on 22/04/2020 AD
 * @project leaveSystem
 **/


public final class LeaveRequestTrackerMapper implements ResultSetExtractor<List<LeaveRequestTrackerEntity>> {

    private static List<LeaveRequestTrackerEntity> leaveRequestTracker=null;


    @Override
    public List<LeaveRequestTrackerEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {

        Long levID=null;
        LeaveRequestTrackerEntity leaveEntity = null;
        List<LeaveRequestDeductionDetails> leaveRequestDeductionDetails= null;
        while (rs.next()) {

            if (levID==null || levID !=rs.getInt("leaveId")) {
                if(levID!=null && leaveEntity != null){
                    leaveEntity.setLeaveRequestDeductionDetails(leaveRequestDeductionDetails);
                    this.leaveRequestTracker.add(leaveEntity);
                }
                leaveEntity = new LeaveRequestTrackerEntity();
                leaveRequestDeductionDetails= new ArrayList<>();

                LeaveRequestTrackerMapper(rs,leaveEntity);
                levID= leaveEntity.getLeaveId().Id;

            }
            leaveRequestDeductionDetails.add(LeaveRequestDeductionDetailsMapper(rs));
        }

        return this.leaveRequestTracker;
    }

    public LeaveRequestTrackerEntity LeaveRequestTrackerMapper(ResultSet rs,LeaveRequestTrackerEntity pLeaveRequestTracker) throws SQLException {
        pLeaveRequestTracker = new LeaveRequestTrackerEntity();
        pLeaveRequestTracker.setLeaveId(new LeaveId(rs.getLong("leaveId")));
        pLeaveRequestTracker.setLeaveRequestDetailsInfo(
                new LeaveRequestInfo(new EmployeeNID(rs.getLong("employeeNID")),
                        new LeaveStartDate(LocalDate.parse(rs.getString("leaveStartDate_AH")),LocalDate.parse(rs.getDate("leaveStartDate_AD").toString())),
                        rs.getInt("numberOfDaysLeave")));
        pLeaveRequestTracker.setRequestTimeStamp(rs.getTimestamp("requestTimeStamp"));
        pLeaveRequestTracker.setRequestStatus(new LeaveRequestStatus(rs.getString("status")));

        return pLeaveRequestTracker;
    }

    public LeaveRequestDeductionDetails LeaveRequestDeductionDetailsMapper(ResultSet rs) throws SQLException {
        return new LeaveRequestDeductionDetails(rs.getInt("deductionYears"),rs.getInt("deductionNumberOfDays"));

    }
}


