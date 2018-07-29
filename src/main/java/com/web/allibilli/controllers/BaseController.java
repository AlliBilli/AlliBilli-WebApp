package com.web.allibilli.controllers;


import com.web.allibilli.attributeConstants.ScopeAttributes;
import com.web.allibilli.beans.LogonBean;
import com.web.allibilli.services.BaseService;
import com.web.allibilli.services.GenericService;
import com.web.allibilli.services.NotificationService;
import com.web.allibilli.services.RegistrationService;
import com.web.allibilli.services.admin.main.MainAdminService;
import com.web.allibilli.services.sandboxService.SandboxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	private AbstractHttpMessageConverter<String> stringHttpMessageConverter = new StringHttpMessageConverter();
	private MediaType jsonMimeType = MediaType.APPLICATION_JSON;

	@Autowired
	protected BaseService baseService;

	@Autowired
	protected SandboxService sandboxService;

	@Autowired
	protected RegistrationService registrationService;

	@Autowired
	protected GenericService genericService;

	@Autowired
	protected MainAdminService mainAdminService;
	
	@Autowired
	protected NotificationService notificationService;
	
	
	
	protected void writeJSONDataToResponse(HttpServletResponse response, String jsonData) {

		logger.info("-->{}", jsonData);
		if (stringHttpMessageConverter.canWrite(String.class, jsonMimeType)) {
			try {
				stringHttpMessageConverter.write(jsonData, jsonMimeType, new ServletServerHttpResponse(response));
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

		}
	}

	public LogonBean isSessionAlive(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession();
		// baseService.setHttpSession(httpSession);
		return (LogonBean) httpSession.getAttribute(ScopeAttributes.USER_DEATILS);

	}

	public boolean isSendSessionExpiredMessage(HttpServletResponse response, LogonBean logonBean) throws Exception {

		if (logonBean == null) {
			// response.sendRedirect("index.jsp");
			String jsonData = baseService.buildSessionExpiredJSON(false, "Session Expired");
			// jsonData =
			// "{\"exceptionMessage\":\"Session Expired\",\"sessionExpired\":true,\"success\":false, \"studentDetails\":[]}"
			// ;
			writeJSONDataToResponse(response, jsonData);
			return true;
		}

		return false;
	}

	@PostConstruct
	public void printVCAPServices()
	{
		logger.debug("VCAP_SERVICES--->{}", System.getenv("VCAP_SERVICES"));
	}
}
