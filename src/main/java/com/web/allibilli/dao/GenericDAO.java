package com.web.allibilli.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.allibilli.attributeConstants.GenericConstants;
import com.web.allibilli.beans.PropertiesBean;
import com.web.allibilli.storedProcs.devCredits.GetDevCreditsProc;
import com.web.allibilli.utils.JDBCPROPS;
@Component
public class GenericDAO extends JDBCPROPS {

	private static final Logger logger = LoggerFactory.getLogger(GenericDAO.class);

	@Autowired
	PropertiesBean propBean;

	public Map<String, Object> listDevCredits() {

		Map<String, Object> map = new HashMap<String, Object>();

		try {

			logger.debug("Listing Dev Credits ...");
			GetDevCreditsProc proc = new GetDevCreditsProc(jdbcTemplate, GenericConstants.PROC_GET_DEV_CREDITS_DATA);
			map = proc.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

}
