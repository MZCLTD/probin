package com.mz.probin.entities;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class GrantApplication {
	
	private String title;
	private String nameOfOwnerOfEstate;
	private String relationshipWithTheDeasesed;
	private String occupationOfTheDesased;
	private String valueOfTheProperties;
	private String jurisdictionOfWhichHighCourt;
	private String datez;
	private MultipartFile multipartFile;
	
	// for index object
	private String status;
	private String applicationId;
	private String dateOfApplication;
	private String fullnameOfApplicant;

	
	// getters and setters
	public String getNameOfOwnerOfEstate() {
		return nameOfOwnerOfEstate;
	}
	public void setNameOfOwnerOfEstate(String nameOfOwnerOfEstate) {
		this.nameOfOwnerOfEstate = nameOfOwnerOfEstate;
	}
	public String getRelationshipWithTheDeasesed() {
		return relationshipWithTheDeasesed;
	}
	public void setRelationshipWithTheDeasesed(String relationshipWithTheDeasesed) {
		this.relationshipWithTheDeasesed = relationshipWithTheDeasesed;
	}
	public String getOccupationOfTheDesased() {
		return occupationOfTheDesased;
	}
	public void setOccupationOfTheDesased(String occupationOfTheDesased) {
		this.occupationOfTheDesased = occupationOfTheDesased;
	}
	public String getValueOfTheProperties() {
		return valueOfTheProperties;
	}
	public void setValueOfTheProperties(String valueOfTheProperties) {
		this.valueOfTheProperties = valueOfTheProperties;
	}
	public String getJurisdictionOfWhichHighCourt() {
		return jurisdictionOfWhichHighCourt;
	}
	public void setJurisdictionOfWhichHighCourt(String jurisdictionOfWhichHighCourt) {
		this.jurisdictionOfWhichHighCourt = jurisdictionOfWhichHighCourt;
	}
	public String getDatez() {
		return datez;
	}
	public void setDatez(String datez) {
		this.datez = datez;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getFullnameOfApplicant() {
		return fullnameOfApplicant;
	}
	public void setFullnameOfApplicant(String fullnameOfApplicant) {
		this.fullnameOfApplicant = fullnameOfApplicant;
	}
	
	
	

}
