package com.beans;

public class SendEmailBean
{
	String	message;
	String	parentEmailId;
	String	kumonLevel;
	String	firstName;
	String	emailsubject;

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getParentEmailId()
	{
		return parentEmailId;
	}

	public void setParentEmailId(String parentEmailId)
	{
		this.parentEmailId = parentEmailId;
	}

	public String getKumonLevel()
	{
		return kumonLevel;
	}

	public void setKumonLevel(String kumonLevel)
	{
		this.kumonLevel = kumonLevel;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getEmailsubject()
	{
		return emailsubject;
	}

	public void setEmailsubject(String emailsubject)
	{
		this.emailsubject = emailsubject;
	}

}
