package com.storedProcs.sandbox;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.beans.dbTblMappings.TREEELEMENTS;
import com.beans.sandbox.TreeElementsBean;

public class SandboxTreeElementslMapper implements RowMapper<TreeElementsBean> {

	public TreeElementsBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		TreeElementsBean bean = new TreeElementsBean();

		bean.setAccdId(rs.getInt(TREEELEMENTS.accdId));
		bean.setEleId(rs.getInt(TREEELEMENTS.eleId));
		bean.setText(rs.getString(TREEELEMENTS.text));
		bean.setEleUrl(rs.getString(TREEELEMENTS.eleUrl));
		bean.setOrderList(rs.getInt(TREEELEMENTS.orderList));
		bean.setRootId(rs.getInt(TREEELEMENTS.rootId));
		bean.setLeaf(rs.getBoolean(TREEELEMENTS.leaf));
		bean.setExpanded(rs.getBoolean(TREEELEMENTS.expanded));

		return bean;

	}
}
