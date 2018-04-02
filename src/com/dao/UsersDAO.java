package com.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beans.PropertiesBean;
import com.beans.userRegister.UsersBean;
import com.utils.JDBCPROPS;
@Component
public class UsersDAO extends JDBCPROPS {

	private static final Logger logger = LoggerFactory.getLogger(UsersDAO.class);

	@Autowired
	PropertiesBean propBean;

	public String retrievePassword(String logonName, String emailId) {

		String password = "";
		Object[] params = new Object[] { logonName, emailId };

		try {
			logger.debug("Looking for user...");
			//String qry = propBean.getRetrievePassword_qry();
			//password = (String) this.jdbcTemplate.queryForObject(qry, params,
			//		String.class);
		} catch (Exception e) {
			password = "";
			e.printStackTrace();
		}

		return password;

	}

	public int registerUser(final UsersBean userBean) {


		int id = -1;
		
		try {
			logger.debug("Registering new User...");

//			if (checkUser(userBean.getLogonName()) > 0)
//				throw new Exception("User is alreday available");
//			
//			RegisterUserProc proc = new RegisterUserProc(jdbcTemplate, GenericConstants.PROC_USER_REGISTRATION, userBean);
//			Map<String, Object> map = proc.execute();
//			List l = (List) map.get("rs");
//			id = (Integer) l.get(0);

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return id;
	}
	
	
	public int checkUser(String userName) {
		int count = -1;
		Object[] params = new Object[] { userName };

		try {
			logger.debug("Looking for user...");
			//String qry = propBean.getCheckUserName_qry();
			//count = this.jdbcTemplate.queryForInt(qry, params);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public int activateUser(String userId) {
		int count = -1;
		Object[] params = new Object[] { userId };

		try {
			logger.debug("Updating user...");
			//String qry = propBean.getActivateUser_qry();
			//count = this.jdbcTemplate.update(qry, params);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	public int isUserActive(String userId) {
		int count = -1;
		Object[] params = new Object[] { userId };

		try {
			logger.debug("Updating user...");
			//String qry = propBean.getIsUserActive_qry();
			//count = this.jdbcTemplate.queryForInt(qry, params);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

}
