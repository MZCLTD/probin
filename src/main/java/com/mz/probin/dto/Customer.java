package com.mz.probin.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class Customer implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String customerName;
	private String email;
	private String telephone;
	private String contactAddress;
	private MultipartFile scannedWillillLAndAMpf;
	private String scannedWillLandAMpfUrl;
	
	private String applicationId;
	
	// getters and setters
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public MultipartFile getScannedWillillLAndAMpf() {
		return scannedWillillLAndAMpf;
	}
	public void setScannedWillillLAndAMpf(MultipartFile scannedWillillLAndAMpf) {
		this.scannedWillillLAndAMpf = scannedWillillLAndAMpf;
	}
	public String getScannedWillLandAMpfUrl() {
		return scannedWillLandAMpfUrl;
	}
	public void setScannedWillLandAMpfUrl(String scannedWillLandAMpfUrl) {
		this.scannedWillLandAMpfUrl = scannedWillLandAMpfUrl;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

}
