package com.storedProcs.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import com.beans.userRegister.UsersBean;

public class LogonProc extends StoredProcedure {
//	UserBean bean;
	
	public LogonProc(JdbcTemplate jdbcTemplate, String procName,
			UsersBean bean)
	{
		super(jdbcTemplate, procName);
//		declareParameter(new SqlParameter("_logonName", Types.VARCHAR));
//		declareParameter(new SqlParameter("_password", Types.VARCHAR));
//		declareParameter(new SqlParameter("_emailId", Types.VARCHAR));
//		declareParameter(new SqlParameter("_completeName", Types.VARCHAR));
//		declareParameter(new SqlParameter("_kumonAddress", Types.VARCHAR));
//		declareParameter(new SqlParameter("_phoneNumber", Types.VARCHAR));
//		declareParameter(new SqlParameter("_isActive", Types.BOOLEAN));
////		declareParameter(new SqlReturnResultSet("rs", new UserMapper()));
//		this.bean = bean;
		compile();
	}

	public Map<String, Object> execute()
	{

		Map<String, Object> inputs = new HashMap<String, Object>();
//		inputs.put("_logonName", bean.getLogonName());
//		inputs.put("_password", bean.getPassword());
//		inputs.put("_emailId", bean.getEmailId());
//		inputs.put("_completeName", bean.getCompleteName());
//		inputs.put("_kumonAddress", bean.getKumonAddress());
//		inputs.put("_phoneNumber", bean.getPhoneNumber());
//		inputs.put("_isActive", bean.getIsActive());
		return super.execute(inputs);
	}

}
