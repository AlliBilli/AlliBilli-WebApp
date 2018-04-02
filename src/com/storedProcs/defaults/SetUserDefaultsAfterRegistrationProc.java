package com.storedProcs.defaults;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class SetUserDefaultsAfterRegistrationProc extends StoredProcedure
{
	int userId;
	 String timezone;
	 
	public SetUserDefaultsAfterRegistrationProc(JdbcTemplate jdbcTemplate, String procName,
			int userId,  String timezone)
	{
		super(jdbcTemplate, procName);

		declareParameter(new SqlParameter("userId", Types.INTEGER));
		declareParameter(new SqlParameter("timezone", Types.VARCHAR));
		
		this.userId = userId;
		this.timezone = timezone;
		compile();
	}

	public Map<String, Object> execute()
	{

		Map<String, Object> inputs = new HashMap<String, Object>();
		inputs.put("userId", this.userId);
		inputs.put("timezone", this.timezone);
		return super.execute(inputs);
	}
}
