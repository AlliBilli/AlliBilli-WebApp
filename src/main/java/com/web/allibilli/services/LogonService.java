package com.web.allibilli.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.web.allibilli.beans.PropertiesBean;

@Service
public class LogonService extends BaseService
{

	private static final Logger logger = LoggerFactory.getLogger(LogonService.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PropertiesBean propBean;

	@Autowired
	DatabaseConstansService dbConstService;

//	public Boolean tryLoggingIn(LogonBean logonBean, HttpServletRequest request) throws Exception
//	{
//
//		Object[] params = new Object[]
//		{ logonBean.getLogonName(), logonBean.getPassword() };
//
//		UsersBean logonResultBean = new UsersBean();
//
//		try
//		{
//			logonResultBean = (UsersBean) jdbcTemplate.queryForObject(propBean.getTryLogginIn_qry(),
//					params, new RowMapper<UsersBean>()
//					{
//						public UsersBean mapRow(ResultSet rs, int rowNum)
//								throws SQLException
//						{
//							UsersBean lgnBean = new UsersBean();
//							return lgnBean;
//						}
//					});
//			
//		} catch (Exception e)
//		{
//			logger.warn(e.getMessage());
//		}
//	}

}
