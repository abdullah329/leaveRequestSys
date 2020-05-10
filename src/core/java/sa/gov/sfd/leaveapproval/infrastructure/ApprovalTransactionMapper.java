/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */


package sa.gov.sfd.leaveapproval.infrastructure;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import sa.gov.sfd.leave.core.leaverequest.LeaveId;
import sa.gov.sfd.leaveapproval.core.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abdullahalgarni on 10/05/2020 AD
 * @project leaveSystem
 **/
public final class ApprovalTransactionMapper implements ResultSetExtractor<List<ApprovalTransactionEntity>> {

    private static List<ApprovalTransactionEntity> approvalTransactionEntityList = new ArrayList<>();


    @Override
    public List<ApprovalTransactionEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {

        //todo

        return this.approvalTransactionEntityList;
    }

}
