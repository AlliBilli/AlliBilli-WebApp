package com.web.allibilli.utils;

import java.util.HashMap;
import java.util.List;

import com.web.allibilli.beans.sandbox.AccordiansBean;
import com.web.allibilli.beans.sandbox.TreeElementsBean;

public class Attacher {

	public static void attachTreeElementToAccordian(HashMap<Integer, AccordiansBean> accMap, TreeElementsBean tBean)
	{
		if(accMap.get(tBean.getAccdId())!=null)
			accMap.get(tBean.getAccdId()).getTreeElements().add(tBean);
	}
	
	
	public static HashMap<Integer, AccordiansBean> buildAccordians(List<AccordiansBean> left, List<AccordiansBean> right)
	{
		HashMap<Integer, AccordiansBean> map = new HashMap<Integer, AccordiansBean>();
		
		for(AccordiansBean aBean : left)
		{
			map.put(aBean.getAccdId(), aBean);
		}
		
		for(AccordiansBean aBean : right)
		{
			map.put(aBean.getAccdId(), aBean);
		}
		
		return map;
	}
	
}
