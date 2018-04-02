package com.beans.devCredits;

public class DevCreditsBean {

	private int iddevcredits;
	private String name;
	private String location;
	private String description;
	private String helpType;
	private boolean isArchived;

	public int getIddevcredits() {
		return iddevcredits;
	}

	public void setIddevcredits(int iddevcredits) {
		this.iddevcredits = iddevcredits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHelpType() {
		return helpType;
	}

	public void setHelpType(String helpType) {
		this.helpType = helpType;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

}
