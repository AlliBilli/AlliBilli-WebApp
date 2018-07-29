package com.web.allibilli.beans.userRegister;

import java.sql.Timestamp;
import java.util.TimeZone;

/**
 * @author Chiranjeevi Kancherla
 * 
 */
public class UsersBean { 
	private int userId;
	private String userName = "";
	private String password = "";
	private String dspName = "";
	private String emailId = "";
	private String status = "";
	private TimeZone timeZone;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String pwdHint = "";
	private String pwdAns = "";
	private int dispSet;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDspName() {
		return dspName;
	}

	public void setDspName(String dspName) {
		this.dspName = dspName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getPwdHint() {
		return pwdHint;
	}

	public void setPwdHint(String pwdHint) {
		this.pwdHint = pwdHint;
	}

	public String getPwdAns() {
		return pwdAns;
	}

	public void setPwdAns(String pwdAns) {
		this.pwdAns = pwdAns;
	}

	public int getDispSet() {
		return dispSet;
	}

	public void setDispSet(int dispSet) {
		this.dispSet = dispSet;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
