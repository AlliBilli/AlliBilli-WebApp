package com.storedProcs.devCredits;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.attributeConstants.GenericConstants;

public class GetDevCreditsProc extends StoredProcedure {

	public GetDevCreditsProc(JdbcTemplate jdbcTemplate, String procName) {
		super(jdbcTemplate, procName);
		declareParameter(new SqlReturnResultSet(GenericConstants.LIST_DEV_CREDITS, new GetDevCreditsMapper()));
		
		compile();
	}

	public Map<String, Object> execute() {
		Map<String, Object> inputs = new HashMap<String, Object>();
		return super.execute(inputs);
	}

}
