package sa.gov.sfd.leaveapproval.infrastructure;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import sa.gov.sfd.leaveapproval.core.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abdullahalgarni on 10/05/2020 AD
 * @project leaveSystem
 **/
public final class ApproverTeamMapper implements ResultSetExtractor<List<ApproverTeamEntity>> {

    private static List<ApproverTeamEntity> approverTeamEntityList = new ArrayList<>();


    @Override
    public List<ApproverTeamEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {

        //todo

        return this.approverTeamEntityList;
    }

}