package com.web.allibilli.services;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConstansService extends BaseService
{
	private static final Logger logger = LoggerFactory.getLogger(DatabaseConstansService.class);

	public HashMap<String,Object> listConstants()
	{
		logger.debug("Retrieving the constans");
		return dbConstantsDAO.listDatabaseConstants();
	}
}
