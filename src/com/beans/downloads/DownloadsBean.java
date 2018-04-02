package com.beans.downloads;

public class DownloadsBean {

	private String aStudents = "";
	private String aStudentsEFT = "";
	private String aStudentsOTHER = "";
	private String iStudents = "";
	private String iStudentsEFT = "";
	private String iStudentsOTHER = "";

	public String getaStudents() {
		return aStudents;
	}

	public void setaStudents(String aStudents) {
		this.aStudents = aStudents;
	}

	public String getaStudentsEFT() {
		return aStudentsEFT;
	}

	public void setaStudentsEFT(String aStudentsEFT) {
		this.aStudentsEFT = aStudentsEFT;
	}

	public String getaStudentsOTHER() {
		return aStudentsOTHER;
	}

	public void setaStudentsOTHER(String aStudentsOTHER) {
		this.aStudentsOTHER = aStudentsOTHER;
	}

	public String getiStudents() {
		return iStudents;
	}

	public void setiStudents(String iStudents) {
		this.iStudents = iStudents;
	}

	public String getiStudentsEFT() {
		return iStudentsEFT;
	}

	public void setiStudentsEFT(String iStudentsEFT) {
		this.iStudentsEFT = iStudentsEFT;
	}

	public String getiStudentsOTHER() {
		return iStudentsOTHER;
	}

	public void setiStudentsOTHER(String iStudentsOTHER) {
		this.iStudentsOTHER = iStudentsOTHER;
	}

	public Boolean isAllToDownload() {
		if (aStudents.length() > 0 && aStudentsEFT.length() > 0
				&& aStudentsOTHER.length() > 0 && iStudents.length() > 0
				&& iStudentsEFT.length() > 0 && iStudentsOTHER.length() > 0)
			return true;
		else
			return false;
	}

	public Boolean isAllActiveToDownload() {
		if (aStudents.length() > 0 && aStudentsEFT.length() > 0
				&& aStudentsOTHER.length() > 0 && iStudents.length() == 0
				&& iStudentsEFT.length() == 0 && iStudentsOTHER.length() == 0)
			return true;
		else
			return false;
	}

	public Boolean isAllInActiveToDownload() {
		if (aStudents.length() == 0 && aStudentsEFT.length() == 0
				&& aStudentsOTHER.length() == 0 && iStudents.length() > 0 && iStudentsEFT.length() > 0
				&& iStudentsOTHER.length() > 0)
			return true;
		else
			return false;
	}
}
