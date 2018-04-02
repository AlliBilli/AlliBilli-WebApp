package com.storedProcs.registerUser;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public final class UserMapper implements RowMapper<Integer>
{

	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		int idUser=-1;
		try
		{
			idUser = rs.getInt("uuid");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return idUser;
	}
}
