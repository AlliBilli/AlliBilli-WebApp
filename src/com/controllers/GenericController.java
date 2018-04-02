package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GenericController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(GenericController.class);

	@RequestMapping(value = "/listDevCredits.do", method = RequestMethod.GET)
	public void loginGet(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("Listing Sandbox Components --> ");

		String jsonData = genericService.getDevCreditsJson();
		writeJSONDataToResponse(response, jsonData);
	}
}
