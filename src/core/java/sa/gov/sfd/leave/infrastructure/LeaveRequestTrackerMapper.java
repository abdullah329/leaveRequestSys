/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */

package sa.gov.sfd.leave.infrastructure;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import sa.gov.sfd.leave.core.leaverequest.*;
import sa.gov.sfd.leaveapproval.core.EmployeeNID;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abdullahalgarni on 22/04/2020 AD
 * @project leaveSystem
 **/


public final class LeaveRequestTrackerMapper implements ResultSetExtractor<List<LeaveRequestEntity>> {

    private static List<LeaveRequestEntity> leaveRequestTracker=null;


    @Override
    public List<LeaveRequestEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {

        Long levID=null;
        LeaveRequestEntity leaveEntity = null;
        List<LeaveRequestDeductionDetails> leaveRequestDeductionDetails= null;
        while (rs.next()) {

            if (levID==null || levID !=rs.getInt("leaveId")) {
                if(levID!=null && leaveEntity != null){
                    leaveEntity.setLeaveRequestDeductionDetails(leaveRequestDeductionDetails);
                    this.leaveRequestTracker.add(leaveEntity);
                }
                leaveEntity = new LeaveRequestEntity();
                leaveRequestDeductionDetails= new ArrayList<>();

                LeaveRequestTrackerMapper(rs,leaveEntity);
                levID= leaveEntity.getLeaveId().Id;

            }
            leaveRequestDeductionDetails.add(LeaveRequestDeductionDetailsMapper(rs));
        }

        return this.leaveRequestTracker;
    }

    public LeaveRequestEntity LeaveRequestTrackerMapper(ResultSet rs, LeaveRequestEntity pLeaveRequestTracker) throws SQLException {
        pLeaveRequestTracker = new LeaveRequestEntity();
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


