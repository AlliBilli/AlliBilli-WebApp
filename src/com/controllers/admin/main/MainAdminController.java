package com.controllers.admin.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beans.hibernate.TreeElements;
import com.controllers.BaseController;

@Controller
public class MainAdminController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(MainAdminController.class);

	@RequestMapping(value = "/showAdminPage.do", method = RequestMethod.GET)
	public ModelAndView showAdminPage( HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("Forwarding to mainAdmin Jsp Page");
		ModelAndView view = new ModelAndView("administration/mainAdmin");
		return view;

	}
	
	@RequestMapping(value = "/crudElement.do", method = RequestMethod.POST)
	public ModelAndView mainAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("Forwarding to mainAdmin Jsp Page");
		ModelAndView view = new ModelAndView("administration/mainAdmin");
		return view;

	}
	@RequestMapping(value = "/loadAccordians.do", method = RequestMethod.GET)
	public @ResponseBody String loadAccordians(@RequestParam int panelId, HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("Loading Accordians...");
		String resp = mainAdminService.loadAccordians(panelId);
		System.out.println(resp);
		return resp;

	}
	@RequestMapping(value = "/loadTreeRoots.do", method = RequestMethod.GET)
	public @ResponseBody String loadTreeRoots(@RequestParam int accdId, HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("Loading Tree Roots...");
		String resp = mainAdminService.loadTreeRoots(accdId);
		System.out.println(resp);
		return resp;

	}
	@RequestMapping(value = "/loadTreeElements.do", method = RequestMethod.GET)
	public @ResponseBody String loadTreeElements(@RequestParam int treeRootId, HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("Loading Elements...");
		String resp = mainAdminService.loadTreeElements(treeRootId);
		System.out.println(resp);
		return resp;

	}
	@RequestMapping(value = "/loadTreeElement.do", method = RequestMethod.GET)
	public void loadTreeElement(@RequestParam int eleId, HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("Loading Tree Element...");
		String resp = mainAdminService.loadTreeElement(eleId);
		System.out.println(resp);
		writeJSONDataToResponse(response, resp);

	}
	@RequestMapping(value = "/createElement.do", method = RequestMethod.POST)
	public void saveOrUpdateElement(@RequestParam String secretCode, @RequestParam String operation,@ModelAttribute TreeElements bean, HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("Loading Accordians...");
		logger.debug("Leaf ----> ...{}",bean.getLeaf());
		if(secretCode.equals("Greeshma"))
			mainAdminService.saveOrUpdateElement(operation,bean);
		//System.out.println(resp);
		//return resp;

	}
	@RequestMapping(value = "/reportInvalid.do", method = RequestMethod.GET)
	public @ResponseBody String reportInvalid(@RequestParam String eleId,@RequestParam String text,@RequestParam String eleURL, HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("Loading Accordians...");
		StringBuilder builder = new StringBuilder();
		builder.append("<BR><BR><BR>Ele Id : ").append(eleId).append("<BR> Title : ").append(text).append("<BR> URL : ").append(eleURL).append("<BR><BR><BR>");
		notificationService.sendEmail("haigopi@gmail.com", builder.toString());
		return "{\"success\":true}";
		

	}
}
