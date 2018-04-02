package com.controllers.logon;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beans.LogonBean;
import com.controllers.BaseController;

@Controller
public class LoginController extends BaseController
{

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	
	@RequestMapping(value = "/logon.do", method = RequestMethod.GET)
	public ModelAndView loginGet(@ModelAttribute LogonBean logonBean,
			HttpServletRequest request)
	{
		logger.debug("Checking User Credentials for User --> "
				+ logonBean.getLogonName());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("logonForm/logonForm");

		return mav;
	}

	
	@RequestMapping(value = "/logon.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute LogonBean logonBean,
			HttpServletRequest request)
	{
		logger.debug("Checking User Credentials for User --> "
				+ logonBean.getLogonName());

		ModelAndView mav = new ModelAndView();

	
		return mav;
	}

	@RequestMapping(value = "/privacy.do", method = RequestMethod.GET)
	public ModelAndView privacy(@ModelAttribute LogonBean logonBean,
			HttpServletRequest request)
	{
		logger.debug("Forwarding to Privacy --> ");

		ModelAndView mav = new ModelAndView();

		mav.setViewName("general/privacy");

		return mav;
	}

	@RequestMapping(value = "/legal.do", method = RequestMethod.GET)
	public ModelAndView legal(@ModelAttribute LogonBean logonBean,
			HttpServletRequest request)
	{
		logger.debug("Forwarding to Legal --> ");

		ModelAndView mav = new ModelAndView();

		mav.setViewName("general/legal");

		return mav;
	}
}
