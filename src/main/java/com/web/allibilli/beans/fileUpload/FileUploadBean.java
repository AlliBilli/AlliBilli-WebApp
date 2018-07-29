package com.web.allibilli.beans.fileUpload;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUploadBean
{
	private CommonsMultipartFile fileData;

	public CommonsMultipartFile getFileData()
	{
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData)
	{
		this.fileData = fileData;
	}


}
