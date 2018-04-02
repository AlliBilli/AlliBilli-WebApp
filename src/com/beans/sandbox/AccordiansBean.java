package com.beans.sandbox;

import java.util.ArrayList;
import java.util.List;

import com.beans.hibernate.Accordians;

@SuppressWarnings("serial")
public class AccordiansBean extends Accordians {

	private List<TreeElementsBean> treeElements = new ArrayList<TreeElementsBean>();

	public List<TreeElementsBean> getTreeElements() {
		return treeElements;
	}

	public void setTreeElements(List<TreeElementsBean> treeElements) {
		this.treeElements = treeElements;
	}

}
