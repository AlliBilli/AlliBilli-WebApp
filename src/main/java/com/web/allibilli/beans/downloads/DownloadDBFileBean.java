package com.web.allibilli.beans.downloads;

import java.io.InputStream;

public class DownloadDBFileBean
{
	InputStream fileContent;
	String contentType;
	String fileName;
	String fileType;
	
	public InputStream getFileContent()
	{
		return fileContent;
	}
	public void setFileContent(InputStream fileContent)
	{
		this.fileContent = fileContent;
	}
	public String getContentType()
	{
		return contentType;
	}
	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getFileType()
	{
		return fileType;
	}
	public void setFileType(String fileType)
	{
		this.fileType = fileType;
	}
	
	
}
