package com.storedProcs.databaseConstantsProcs;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public final class DBConstantsMapper implements RowMapper<String>
{
	public String mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		return rs.getString(1);
	}
}

