package com.web.allibilli.storedProcs.credentialsmgr;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;

import com.web.allibilli.beans.userRegister.UsersBean;

public class CredentialsDeleteProc extends StoredProcedure{
    
	UsersBean bean;
	public CredentialsDeleteProc(JdbcTemplate jdbcTemplate, String procName) {
		super(jdbcTemplate, procName);
		this.bean = bean;
	}
	
	public Map<String, Object> execute(){
		Map<String, Object> inputs = new HashMap<String, Object>();
		return super.execute(inputs);
	}

}
