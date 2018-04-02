package com.beans.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "treeelements", uniqueConstraints = { @UniqueConstraint(columnNames = "eleId") })
public class TreeElements implements Serializable {
	private int eleId=-1;
	private String text = "";
	private int accdId;
	private int rootId;
	private Boolean leaf;
	private Boolean expanded=false;
	private int orderList = 0;
	private String eleUrl;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public int getEleId() {
		return eleId;
	}

	public void setEleId(int eleId) {
		this.eleId = eleId;
	}

	@Column
	public int getAccdId() {
		return accdId;
	}

	public void setAccdId(int accdId) {
		this.accdId = accdId;
	}

	@Column
	public int getRootId() {
		return rootId;
	}

	public void setRootId(int rootId) {
		this.rootId = rootId;
	}

	@Column
	public int getOrderList() {
		return orderList;
	}

	public void setOrderList(int orderList) {
		this.orderList = orderList;
	}

	@Column
	public String getEleUrl() {
		return eleUrl;
	}

	public void setEleUrl(String eleUrl) {
		this.eleUrl = eleUrl;
	}

	@Column
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column
	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	@Column
	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

}
