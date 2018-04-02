package com.storedProcs.databaseConstantsProcs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

public class GetDatabaseConstansProc extends StoredProcedure
{
	public GetDatabaseConstansProc(JdbcTemplate jdbcTemplate, String procName)
	{
		super(jdbcTemplate, procName);
		//declareParameter(new SqlReturnResultSet(GenericConstants.TBL_SUBJECT, new DBConstantsMapper()));
		compile();
	}

	public Map<String, Object> execute()
	{
		Map<String, Object> inputs = new HashMap<String, Object>();
		return super.execute(inputs);
	}
}
