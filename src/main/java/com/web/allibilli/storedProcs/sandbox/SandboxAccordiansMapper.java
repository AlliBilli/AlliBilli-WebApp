package com.web.allibilli.storedProcs.sandbox;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.web.allibilli.beans.sandbox.AccordiansBean;
import com.web.allibilli.beans.dbTblMappings.ACCORDIANS;

public class SandboxAccordiansMapper implements RowMapper<AccordiansBean> {

	public AccordiansBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		AccordiansBean bean = new AccordiansBean();
		bean.setAccdId(rs.getInt(ACCORDIANS.accdId));
		bean.setAccdName(rs.getString(ACCORDIANS.accdName));
		bean.setOrderList(rs.getInt(ACCORDIANS.orderList));
		bean.setPanelId(rs.getInt(ACCORDIANS.panelId));
		bean.setIconCls(rs.getString(ACCORDIANS.iconCls));
		bean.setExpand(rs.getBoolean(ACCORDIANS.expand));
		return bean;

	}
}
