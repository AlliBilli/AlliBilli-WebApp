package com.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.attributeConstants.GenericConstants;
import com.beans.PropertiesBean;
import com.storedProcs.devCredits.GetDevCreditsProc;
import com.utils.JDBCPROPS;
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
