/*
 * Copyright (c) 2020. Saudi Fund For Development - Abdullah F Algarni
 */


package sa.gov.sfd.leave.infrastructure;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import sa.gov.sfd.leave.core.entitlement.Entitlement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abdullahalgarni on 22/04/2020 AD
 * @project leaveSystem
 **/


public final class EntitlementMapper implements ResultSetExtractor<List<Entitlement>> {

    private static List<Entitlement> entitlementEntityList= new ArrayList<>();


    @Override
    public List<Entitlement> extractData(ResultSet rs) throws SQLException, DataAccessException {

        //todo

        return this.entitlementEntityList;
    }


}


