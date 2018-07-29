package com.web.allibilli.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.allibilli.attributeConstants.GenericConstants;
import com.web.allibilli.beans.PropertiesBean;
import com.web.allibilli.storedProcs.sandbox.GetSandboxDataProc;
import com.web.allibilli.utils.JDBCPROPS;
@Component
public class SandboxDAO extends JDBCPROPS {

	private static final Logger logger = LoggerFactory.getLogger(UsersDAO.class);

	@Autowired
	PropertiesBean propBean;

	public Map<String, Object> listSandboxComponents() {

		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			
			logger.debug("Listing sandbox components...");
			GetSandboxDataProc proc = new GetSandboxDataProc(jdbcTemplate, GenericConstants.PROC_GET_SANDBOX_DATA);
			map = proc.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

}
