package com.web.allibilli.beans.hibernate;

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
@Table(name = "accordians", uniqueConstraints = { @UniqueConstraint(columnNames = "accdId") })
public class Accordians implements Serializable {
	private int accdId;
	private String accdName = "";
	private int panelId;
	private int orderList;
	private String iconCls;
	private Boolean expand;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public int getAccdId() {
		return accdId;
	}

	public void setAccdId(int accdId) {
		this.accdId = accdId;
	}

	@Column
	public String getAccdName() {
		return accdName;
	}

	public void setAccdName(String accdName) {
		this.accdName = accdName;
	}

	@Column
	public int getPanelId() {
		return panelId;
	}

	public void setPanelId(int panelId) {
		this.panelId = panelId;
	}

	@Column
	public int getOrderList() {
		return orderList;
	}

	public void setOrderList(int orderList) {
		this.orderList = orderList;
	}

	@Column
	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	@Column
	public Boolean getExpand() {
		return expand;
	}

	public void setExpand(Boolean expand) {
		this.expand = expand;
	}
}
