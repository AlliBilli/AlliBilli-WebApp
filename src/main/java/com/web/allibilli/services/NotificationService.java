package com.web.allibilli.services;

import java.util.HashMap;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.web.allibilli.beans.LogonBean;
import com.web.allibilli.beans.RecommendationBean;
import com.web.allibilli.beans.SendEmailBean;

@Service
public class NotificationService extends BaseService
{

	private HttpSession httpSession;

	public void sendEmail(String to, String body)
			throws Exception
	{
		HashMap<String, String> myMap = getEmailMap("AlliBilli - Invalid URL Reported",
				to, null, null,
				body, null);
		sendEmail(myMap);

	}

	public void sendEmail(LogonBean logonBean, SendEmailBean bean)
			throws Exception
	{
		String emailBody = getEmailBody(bean, VM_SEND_EMAIL_NOTIFICATION);

		HashMap<String, String> myMap = getEmailMap(bean.getEmailsubject(),
				bean.getParentEmailId(), null, logonBean.getEmailId(),
				emailBody, logonBean.getEmailId());

		sendEmail(myMap);

	}

	public void sendRecommendation(LogonBean logonBean, RecommendationBean recBean, SendEmailBean bean)
			throws Exception
	{
		String emailBody = getEmailBody(recBean, VM_RECOMMENDATION_EMAIL_NOTIFICATION);

		HashMap<String, String> myMap = getEmailMap(bean.getEmailsubject(),
				bean.getParentEmailId(), logonBean.getEmailId(), "hello_gopi@yahoo.com",
				emailBody, logonBean.getEmailId());

		sendEmail(myMap);

	}


	public HttpSession getHttpSession()
	{
		return httpSession;
	}

	public void setHttpSession(HttpSession httpSession)
	{
		this.httpSession = httpSession;
	}

}
