package com.web.allibilli.beans;

import org.springframework.stereotype.Component;

@Component
public class PropertiesBean {


	boolean isToSendEmail = true;

	public boolean getIsToSendEmail() {
		return isToSendEmail;
	}

	public void setIsToSendEmail(boolean isToSendEmail) {
		this.isToSendEmail = isToSendEmail;
	}

}
