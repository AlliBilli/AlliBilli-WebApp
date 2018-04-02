package com.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.attributeConstants.GenericConstants;
import com.storedProcs.databaseConstantsProcs.GetDatabaseConstansProc;
import com.utils.JDBCPROPS;
@Component
public class DatabaseConstantsDAO extends JDBCPROPS
{
	
	public HashMap<String,Object> listDatabaseConstants()
	{
		GetDatabaseConstansProc proc = new GetDatabaseConstansProc(jdbcTemplate, GenericConstants.PROC_DATEBASE_CONSTANTS);
		Map<String, Object> m  = proc.execute();
		
		HashMap<String,Object> constantsMap = new HashMap<String,Object>();
//		constantsMap.put(GenericConstants.TBL_KUMON_LEVEL, (List<String>)m.get(GenericConstants.TBL_KUMON_LEVEL));
//		constantsMap.put(GenericConstants.TBL_PAYMENT_OPTIONS, (List<String>)m.get(GenericConstants.TBL_PAYMENT_OPTIONS));
//		constantsMap.put(GenericConstants.TBL_STUDENT_GRADE, (List<String>)m.get(GenericConstants.TBL_STUDENT_GRADE));
//		constantsMap.put(GenericConstants.TBL_STUDENT_STATUS, (List<String>)m.get(GenericConstants.TBL_STUDENT_STATUS));
//		constantsMap.put(GenericConstants.TBL_SUBJECT, (List<String>)m.get(GenericConstants.TBL_SUBJECT));
		
		return constantsMap;
	}
}
