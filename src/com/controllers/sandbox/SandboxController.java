package com.controllers.sandbox;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.controllers.BaseController;

@Controller
public class SandboxController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(SandboxController.class);
	@RequestMapping(value = "/listSandboxComponents.do", method = RequestMethod.GET)
	public void loginGet(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.debug("Listing Sandbox Components --> ");

		String jsonData = sandboxService.listSandBoxComponents();
		
		writeJSONDataToResponse(response, jsonData);
		logger.debug("Response Sent");
	}
}
