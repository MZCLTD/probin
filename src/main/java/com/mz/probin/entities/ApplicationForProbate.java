package com.mz.probin.entities;

import org.springframework.web.multipart.MultipartFile;

public class ApplicationForProbate {
	
	private String nameOfApplicat;
	private String applicationId;
	private String dateOfApplication;
	private MultipartFile multipartFile;
	
	// getters and setters
	public String getNameOfApplicat() {
		return nameOfApplicat;
	}
	public void setNameOfApplicat(String nameOfApplicat) {
		this.nameOfApplicat = nameOfApplicat;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getDateOfApplication() {
		return dateOfApplication;
	}
	public void setDateOfApplication(String dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	
	
	
	
	

}
