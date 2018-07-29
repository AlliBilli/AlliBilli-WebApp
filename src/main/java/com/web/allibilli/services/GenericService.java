package com.web.allibilli.services;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.web.allibilli.attributeConstants.GenericConstants;
import com.web.allibilli.beans.devCredits.DevCreditsBean;

@Service
public class GenericService extends BaseService {

	private static final Logger logger = LoggerFactory.getLogger(GenericService.class);

	public String getDevCreditsJson() {

		Map<String, Object> map = genericDAO.listDevCredits();
		String jsonString = "";

		if (map.size() > 0) {

			logger.debug("Retriving the list of dev Credits components...");

			@SuppressWarnings("unchecked")
			List<DevCreditsBean> list = (List<DevCreditsBean>) map.get(GenericConstants.LIST_DEV_CREDITS);

			jsonString = buildJSON(GenericConstants.SUCCESS_TRUE, GenericConstants.JSON_DEV_CREDITS, list);
		}
		logger.debug(jsonString);
		return jsonString;
	}
}
