package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("UploadID")
	private int uploadId;

	// ! File name without extension.
	@JsonProperty("Title")
	private String title;

	// ! File extension.
	@JsonProperty("Extension")
	private String extension;

	// ! File size.
	@JsonProperty("Size")
	private long size;

	//@JsonProperty("FileInformationType")
	//private int fileInformationType;

	//@JsonProperty("TempFilePath")
	//private String tempFilePath;
	
	public UploadInfo() {
	}

	public int getUploadId() {
		return uploadId;
	}

	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	/*public int getFileInformationType() {
		return fileInformationType;
	}

	public void setFileInformationType(int fileInformationType) {
		this.fileInformationType = fileInformationType;
	}

	public String getTempFilePath() {
		return tempFilePath;
	}

	public void setTempFilePath(String tempFilePath) {
		this.tempFilePath = tempFilePath;
	}*/
}
