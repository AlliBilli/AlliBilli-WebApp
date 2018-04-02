package com.storedProcs.credentialsmgr;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import com.beans.userRegister.UsersBean;

public class CredentialsAddProc extends StoredProcedure{
    
	UsersBean bean;
	public CredentialsAddProc(JdbcTemplate jdbcTemplate, String procName) {
		super(jdbcTemplate, procName);
		this.bean = bean;
	}
	
	public Map<String, Object> execute(){
		Map<String, Object> inputs = new HashMap<String, Object>();
		return super.execute(inputs);
	}

}
