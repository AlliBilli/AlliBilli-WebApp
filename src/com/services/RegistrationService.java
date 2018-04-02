package com.services;

import org.springframework.stereotype.Service;

import com.beans.userRegister.UsersBean;

@Service
public class RegistrationService extends BaseService {
	
	public boolean registerUser( UsersBean usersBean)
	{
//		buildJSON(true,GenericConstants.LIST_USER_DETAILS, );
		return true;
	}
}
