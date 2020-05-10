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


public final class LeaveRequestMapper implements ResultSetExtractor<List<LeaveRequestEntity>> {

    private static List<LeaveRequestEntity> leaveRequestList = new ArrayList<>();


    @Override
    public List<LeaveRequestEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {

        Long levID=null;
        LeaveRequestEntity leaveEntity = null;
        List<LeaveRequestDeductionDetails> leaveRequestDeductionDetails= null;
        while (rs.next()) {

            if (levID==null || levID !=rs.getInt("leaveId")) {
                if(levID!=null && leaveEntity != null){
                    leaveEntity.setLeaveRequestDeductionDetails(leaveRequestDeductionDetails);
                    this.leaveRequestList.add(leaveEntity);
                }
                leaveRequestDeductionDetails= new ArrayList<>();
                leaveEntity = LeaveRequestMapper(rs);
                levID= leaveEntity.getLeaveId().Id;

            }
            leaveRequestDeductionDetails.add(LeaveRequestDeductionDetailsMapper(rs));
        }

        return this.leaveRequestList;
    }

    public LeaveRequestEntity LeaveRequestMapper(ResultSet rs) throws SQLException {
        LeaveRequestEntity pLeaveRequest = new LeaveRequestEntity();
        pLeaveRequest.setLeaveId(new LeaveId(rs.getLong("leaveId")));
        pLeaveRequest.setLeaveRequestDetailsInfo(
                new LeaveRequestInfo(new EmployeeNID(rs.getLong("employeeNID")),
                        new LeaveStartDate(LocalDate.parse(rs.getString("leaveStartDate_AH")),LocalDate.parse(rs.getDate("leaveStartDate_AD").toString())),
                        rs.getInt("numberOfDaysLeave")));
        pLeaveRequest.setRequestStatus(new LeaveRequestStatus(rs.getString("status")));

        return pLeaveRequest;
    }

    public LeaveRequestDeductionDetails LeaveRequestDeductionDetailsMapper(ResultSet rs) throws SQLException {
        return new LeaveRequestDeductionDetails(rs.getInt("deductionYears"),rs.getInt("deductionNumberOfDays"));

    }
}


