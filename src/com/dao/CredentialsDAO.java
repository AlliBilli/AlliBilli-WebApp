package com.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.attributeConstants.GenericConstants;
import com.storedProcs.credentialsmgr.CredentialsAddProc;
import com.storedProcs.credentialsmgr.CredentialsDeleteProc;
import com.storedProcs.credentialsmgr.CredentialsUpdateProc;
import com.utils.JDBCPROPS;
@Component
public class CredentialsDAO extends JDBCPROPS {

	private static final Logger logger = LoggerFactory.getLogger(UsersDAO.class);
	
	public Map<String, Object> addCredentials() {

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			
			logger.debug("Adding Credentials ...");
			CredentialsAddProc proc = new CredentialsAddProc(jdbcTemplate, GenericConstants.PROC_ADD_CREDENTIALS);
			map = proc.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> updateCredentials() {

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			
			logger.debug("Update Credentials ...");
			CredentialsUpdateProc proc = new CredentialsUpdateProc(jdbcTemplate, GenericConstants.PROC_UPDATE_CREDENTIALS);
			map = proc.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> deleteCredentials() {

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			
			logger.debug("Deleting Credentials ...");
			CredentialsDeleteProc proc = new CredentialsDeleteProc(jdbcTemplate, GenericConstants.PROC_DELTE_CREDENTIALS);
			map = proc.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

}
