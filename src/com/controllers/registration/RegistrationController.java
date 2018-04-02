package com.controllers.registration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beans.LogonBean;
import com.beans.userRegister.UsersBean;
import com.controllers.BaseController;

@Controller
public class RegistrationController extends BaseController
{

	private static final Logger logger = LoggerFactory
			.getLogger(RegistrationController.class);

	
	@RequestMapping(value = "/registerUser.do", method = RequestMethod.GET)
	public void registerUser(@ModelAttribute UsersBean usersBean,
			HttpServletRequest request)
	{ 
		registrationService.registerUser(usersBean);
	}

}
