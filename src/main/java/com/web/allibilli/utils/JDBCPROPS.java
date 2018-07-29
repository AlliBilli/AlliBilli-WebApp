package com.web.allibilli.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.web.allibilli.beans.PropertiesBean;

@Component
public class JDBCPROPS
{
	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Autowired
	public PropertiesBean propBean;
	
	public JDBCPROPS()
	{
		super();
		
	}

	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public PropertiesBean getPropBean()
	{
		return propBean;
	}

	public void setPropBean(PropertiesBean propBean)
	{
		this.propBean = propBean;
	}

}
