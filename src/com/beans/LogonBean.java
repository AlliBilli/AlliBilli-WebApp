package com.beans;

import java.util.Calendar;
import java.util.TimeZone;

public class LogonBean
{
	private String logonName = "";
	private String password = "";
	private Integer idUsers = -1;
	private String emailId;
	private Boolean isActive = false;
	private String timZone = "";
	
	private Calendar cal  = Calendar.getInstance();
	public final static Boolean LOGON_SUCCESS = true;
	public final static Boolean LOGON_FAIL = false;

	public Calendar getUsrCalendar()
	{
		cal.setTimeZone(TimeZone.getTimeZone(timZone));
		return cal;
	}
	public String getLogonName()
	{
		return logonName;
	}

	public void setLogonName(String logonName)
	{
		this.logonName = logonName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}


	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getIdUsers()
	{
		return idUsers;
	}

	public void setIdUsers(Integer idUsers)
	{
		this.idUsers = idUsers;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public String getTimZone()
	{
		return timZone;
	}

	public void setTimZone(String timZone)
	{
		this.timZone = timZone;
	}
}
