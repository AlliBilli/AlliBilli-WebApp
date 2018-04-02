package com.storedProcs.devCredits;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.beans.devCredits.DevCreditsBean;

public class GetDevCreditsMapper implements RowMapper<DevCreditsBean> {

	public DevCreditsBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		DevCreditsBean bean = new DevCreditsBean();

		bean.setDescription(rs.getString("description"));
		bean.setHelpType(rs.getString("helpType"));
		bean.setIddevcredits(rs.getInt("iddevcredits"));
		bean.setLocation(rs.getString("location"));
		bean.setName(rs.getString("name"));

		return bean;

	}
}
