package com.web.allibilli.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.web.allibilli.attributeConstants.GenericConstants;
import com.web.allibilli.storedProcs.credentialsmgr.CredentialsAddProc;
import com.web.allibilli.storedProcs.credentialsmgr.CredentialsDeleteProc;
import com.web.allibilli.storedProcs.credentialsmgr.CredentialsUpdateProc;
import com.web.allibilli.utils.JDBCPROPS;

import javax.persistence.EntityManagerFactory;

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
