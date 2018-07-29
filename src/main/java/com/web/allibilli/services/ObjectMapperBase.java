package com.web.allibilli.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.allibilli.attributeConstants.GenericConstants;

@Service
public class ObjectMapperBase {


//	ObjectMapper mapper = new ObjectMapper();

	
	protected Map<String, Object> buildListBasedMap(Boolean isSuccess,
			String listType, List<?> list) {
		HashMap<String, Object> myMap = new HashMap<String, Object>();

		myMap.put(GenericConstants.JSON_SUCCESS, isSuccess);

		if (listType != null && list != null) {
			myMap.put(GenericConstants.JSON_TOTAL_PROPERTY, list.size());
			myMap.put(listType, list);
		}
		return myMap;
	}

	protected Map<String, Object> buildObjectBasedMap(Boolean isSuccess,
			String listType, Object obj) {
		HashMap<String, Object> myMap = new HashMap<String, Object>();

		myMap.put(GenericConstants.JSON_SUCCESS, isSuccess);

		if (listType != null && obj != null) {
			myMap.put(GenericConstants.JSON_TOTAL_PROPERTY, 1);
			myMap.put(listType, obj);
		}
		return myMap;
	}
	
	protected Map<String, Object> buildSuccessPropertyBasedMap(Boolean isSuccess, String exceptionMessage) {
		HashMap<String, Object> myMap = new HashMap<String, Object>();

		myMap.put(GenericConstants.JSON_SUCCESS, isSuccess);
		myMap.put(GenericConstants.JSON_EXCEPTION_MESSAGE, exceptionMessage);
		return myMap;
	}
	protected Map<String, Object> buildSessionExpiredJsonMap(Boolean isSuccess, String exceptionMessage) {
		HashMap<String, Object> myMap = (HashMap<String, Object>) buildSuccessPropertyBasedMap(isSuccess,exceptionMessage);
		myMap.put("sessionExpired", true);
		return myMap;
	}
}
