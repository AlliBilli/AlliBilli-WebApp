package com.web.allibilli.storedProcs.sandbox;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.web.allibilli.attributeConstants.GenericConstants;
import com.web.allibilli.beans.userRegister.UsersBean;

public class GetSandboxDataProc extends StoredProcedure {

	UsersBean bean;

	public GetSandboxDataProc(JdbcTemplate jdbcTemplate, String procName) {
		super(jdbcTemplate, procName);
		declareParameter(new SqlReturnResultSet(GenericConstants.LIST_TREE_ELEMENTS, new SandboxTreeElementslMapper()));
		declareParameter(new SqlReturnResultSet(GenericConstants.LIST_LEFT_ACCORDIANS, new SandboxAccordiansMapper()));
		declareParameter(new SqlReturnResultSet(GenericConstants.LIST_RIGHT_ACCORDIANS, new SandboxAccordiansMapper()));
		declareParameter(new SqlReturnResultSet(GenericConstants.LIST_PANELS, new SandboxPanelMapper()));
		compile();
	}

	public Map<String, Object> execute() {
		Map<String, Object> inputs = new HashMap<String, Object>();
		return super.execute(inputs);
	}

}
