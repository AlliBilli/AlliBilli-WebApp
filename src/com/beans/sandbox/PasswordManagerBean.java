package com.beans.sandbox;

/**
 * @author Chiranjeevi Kancherla
 * 
 */
public class PasswordManagerBean {
	private int userId;
	private String title = "";
	private String description = "";
	private String url = "";
	private String uName = "";
	private String decrptPwd = "";

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getDecrptPwd() {
		return decrptPwd;
	}

	public void setDecrptPwd(String decrptPwd) {
		this.decrptPwd = decrptPwd;
	}

}
