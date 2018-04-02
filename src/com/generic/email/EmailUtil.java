package com.generic.email;

import java.io.Serializable;
import java.util.HashMap;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.attributeConstants.EmailConstants;
import com.beans.PropertiesBean;

public class EmailUtil implements Serializable
{

	private static String unsub = "<font size=\"1\" face=\"Arial\">To Unsubscribe please <a href=\"http://kumon.allibilli.com/showContactUsForm.do\">click here</a> The information contained in this e-mail, including any attachment(s), is intended solely for use by the named addressee(s).  If you are not the intended recipient, or a person designated as responsible for delivering such messages to the intended recipient, you are not authorized to disclose, copy, distribute or retain this message, in whole or in part, without written authorization from AlliBilli.  This e-mail may contain proprietary, confidential or privileged information. If you have received this message in error, please notify the sender immediately. This notice is included in all e-mail messages leaving AlliBilli.  Thank you for your cooperation.</font>";
	private static final Logger logger = LoggerFactory.getLogger(EmailUtil.class);

	private static final long serialVersionUID = 1L;
	private JavaMailSender mailSender;
	private String fromEmail;

	@Autowired
	PropertiesBean propBean;

	public String getFromEmail()
	{
		return fromEmail;
	}

	public void setFromEmail(String fromEmail)
	{
		this.fromEmail = fromEmail;
	}

	public void sendEmailWithMultipleRecipants(HashMap<String, Object> myMap)
	{
		try
		{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			String subject = (String) myMap.get(EmailConstants.SUBJECT);
			Object to = myMap.get(EmailConstants.TO);
			Object bcc = myMap.get(EmailConstants.BCC);
			Object cc = myMap.get(EmailConstants.CC);
			String emailBody = (String) myMap.get(EmailConstants.EMAILBODY);

			emailBody+=unsub;
			
			String replyTo = (String) myMap.get(EmailConstants.REPLYTO);

			if (to != null && to instanceof String)
			{
				String to_str = (String) to;
				if (to_str.length() > 0)
					helper.setTo(to_str);
			}
			else if (to != null && to.getClass().isArray())
			{
				InternetAddress[] addressTo = (InternetAddress[]) to;
				helper.setTo(addressTo);
			}

			if (cc != null && cc instanceof String)
			{
				String cc_str = (String) cc;
				if (cc_str.length() > 0)
					helper.setCc(cc_str);
			}
			else if (cc != null && cc.getClass().isArray())
			{
				InternetAddress[] addresscc = (InternetAddress[]) cc;
				helper.setCc(addresscc);
			}

			if (bcc != null && bcc instanceof String)
			{
				String bcc_str = (String) bcc;
				if (bcc_str.length() > 0)
					helper.setBcc(bcc_str);
			}
			else if (bcc != null && bcc.getClass().isArray())
			{
				InternetAddress[] addressbcc = (InternetAddress[]) bcc;
				helper.setBcc(addressbcc);
			}

			if (emailBody != null && emailBody.length() > 1)
				helper.setText(emailBody, true);
			if (subject != null && subject.length() > 1)
				helper.setSubject(subject);

			if (replyTo != null && replyTo.length() > 1)
				helper.setReplyTo(replyTo);

			helper.setFrom(fromEmail);
			mailSender.send(message);
			logger.debug("Mail Sent");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void sendEmail(HashMap<String, String> myMap)
	{
		try
		{
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			String subject = myMap.get(EmailConstants.SUBJECT);
			String to = myMap.get(EmailConstants.TO);
			String bcc = myMap.get(EmailConstants.BCC);
			String cc = myMap.get(EmailConstants.CC);
			String emailBody = myMap.get(EmailConstants.EMAILBODY);
			String replyTo = myMap.get(EmailConstants.REPLYTO);

			emailBody+=unsub;
			
			if (replyTo != null && replyTo.length() > 1)
				helper.setReplyTo(replyTo);

			if (to != null && to.length() > 1)
				helper.setTo(to);
			if (bcc != null && (bcc.lastIndexOf(",") == -1) && bcc.length() > 1)
				helper.setBcc(bcc);
			else if (bcc != null && bcc.lastIndexOf(",") > 0)
			{
				String[] arr = bcc.split(",");
				for (String email : arr)
				{
					logger.debug("--> " + email);
					helper.addBcc(email);
				}
			}
			if (cc != null && cc.length() > 1)
				helper.setBcc(cc);
			if (emailBody == null)
			{
				logger.warn("Email Not sent, body is Empty");
				return;
			}
			else
			{
				helper.setText(emailBody, true);
			}
			if (subject != null && subject.length() > 1)
				helper.setSubject(subject);

			helper.setFrom(fromEmail);
			if (propBean.getIsToSendEmail())
			{
				mailSender.send(message);
				logger.debug("Email Sent");
			}
			else
			{
				logger.debug("Email Sent -> Virtual");
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public JavaMailSender getMailSender()
	{
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender)
	{
		this.mailSender = mailSender;
	}

}
