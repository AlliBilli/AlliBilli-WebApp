package com.web.allibilli.storedProcs.registerUser;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.web.allibilli.beans.userRegister.UsersBean;

public class RegisterUserProc extends StoredProcedure
{
	UsersBean bean;

	public RegisterUserProc(JdbcTemplate jdbcTemplate, String procName,
			UsersBean bean)
	{
		super(jdbcTemplate, procName);
		declareParameter(new SqlParameter("_logonName", Types.VARCHAR));
		declareParameter(new SqlParameter("_password", Types.VARCHAR));
		declareParameter(new SqlParameter("_emailId", Types.VARCHAR));
		declareParameter(new SqlParameter("_completeName", Types.VARCHAR));
		declareParameter(new SqlParameter("_kumonAddress", Types.VARCHAR));
		declareParameter(new SqlParameter("_phoneNumber", Types.VARCHAR));
		declareParameter(new SqlParameter("_isActive", Types.BOOLEAN));
		declareParameter(new SqlReturnResultSet("rs", new UserMapper()));
		this.bean = bean;
		compile();
	}

	public Map<String, Object> execute()
	{

		Map<String, Object> inputs = new HashMap<String, Object>();
		return super.execute(inputs);
	}
}
