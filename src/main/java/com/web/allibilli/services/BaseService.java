package com.web.allibilli.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.allibilli.attributeConstants.EmailConstants;
import com.web.allibilli.attributeConstants.VMConstants;
import com.web.allibilli.beans.PropertiesBean;
import com.web.allibilli.dao.CredentialsDAO;
import com.web.allibilli.dao.DatabaseConstantsDAO;
import com.web.allibilli.dao.GenericDAO;
import com.web.allibilli.dao.SandboxDAO;
import com.web.allibilli.dao.UsersDAO;
import com.web.allibilli.dao.admin.main.MainAdminDao;
import com.web.allibilli.generic.email.EmailUtil;

@Service
public class BaseService extends ObjectMapperBase implements VMConstants
{

	private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

	@Autowired
	ObjectMapper mapper;

	@Autowired
	UsersDAO usersDAO;

	@Autowired
	protected SandboxDAO sandBoxDAO;

	@Autowired
	DatabaseConstantsDAO dbConstantsDAO;

	@Autowired
	protected CredentialsDAO credentialsDAO;

	@Autowired
	protected GenericDAO genericDAO;

	@Autowired
	protected MainAdminDao mainAdminDAO;

	@Autowired
	EmailUtil sendEmail;


	@Autowired
	PropertiesBean propBean;

	protected String buildJSON(Boolean isSuccess, String listType, Object obj)
	{
		
		
		String jsonString = "";
		try
		{

			if (obj != null && isSuccess != null)
			{
				if (obj instanceof List<?>)
					jsonString = mapper.writeValueAsString(buildListBasedMap(
							isSuccess, listType, (List<?>) obj));
				else
					jsonString = mapper.writeValueAsString(buildObjectBasedMap(
							isSuccess, listType, obj));
			}
			else if (isSuccess != null)
			{
				jsonString = mapper
						.writeValueAsString(buildSuccessPropertyBasedMap(
								isSuccess, ""));
			}
			else
			{
				jsonString = "";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		logger.debug(jsonString);
		return jsonString;
	}

	public String buildSessionExpiredJSON(Boolean isSuccess, String exceptionMessage)
	{
		
		
		String jsonString = "";
		try
		{

			jsonString = mapper
					.writeValueAsString(buildSessionExpiredJsonMap(isSuccess,
							exceptionMessage));

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		logger.debug(jsonString);
		return jsonString;
	}

	public static HashMap<String, Object> constructEmailMap(Object to, Object cc, Object bcc, String subject, String emailBody, String replyTo)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put(EmailConstants.TO, to);
		map.put(EmailConstants.CC, cc);
		map.put(EmailConstants.BCC, bcc);
		map.put(EmailConstants.SUBJECT, subject);
		map.put(EmailConstants.EMAILBODY, emailBody);
		map.put(EmailConstants.REPLYTO, replyTo);
		return map;
	}
	
	protected HashMap<String, String> getEmailMap(String subject, String to,
			String cc, String bcc, String emailBody, String replyTo)
	{
		HashMap<String, String> myMap = new HashMap<String, String>();

		if (subject != null)
			myMap.put("subject", subject);
		else
			myMap.put("From Kumon Instructor", subject);

		myMap.put(EmailConstants.TO, to);
		myMap.put(EmailConstants.BCC, bcc);
		myMap.put(EmailConstants.CC, cc);
		myMap.put(EmailConstants.REPLYTO, replyTo);

		myMap.put(EmailConstants.EMAILBODY, emailBody);

		return myMap;
	}

	protected String getEmailBody(Object bean, String vmName)
	{
		String signature = "";
	
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(VM_BEAN, bean);
//		if (signature != null && signature.length() > 0)
//			model.put(VM_SIGNATURE, signature);
//		else
//			model.put(VM_SIGNATURE, "Thank you");
//		String emailBody = VelocityEngineUtils.mergeTemplateIntoString(
//				velocityEngine, vmName, model);
		//String emailBody="Not Implemented";
		return null;
	}

	protected void sendEmail(HashMap<String, String> myMap)
	{
		logger.debug("Start Sending Email.");
		sendEmail.sendEmail(myMap);
	}

	protected void sendEmailWithMultipleRecipents(HashMap<String, Object> myMap)
	{
		logger.debug("Start Sending Email.");
		sendEmail.sendEmailWithMultipleRecipants(myMap);
	}

	protected String getFailueJSONTemplate()
	{
		return "{\"success\":false}";
	}

	protected String getSucessJSONTemplate()
	{
		return "{\"success\":true}";
	}
}
