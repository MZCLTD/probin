package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MFilesUser {
	
	@JsonProperty(value = "Username")
	private String username;
	
	@JsonProperty(value = "Password")
	private String password;
	
	@JsonProperty(value = "VaultGuid")
	private String vaultGuid;
	
	public MFilesUser() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVaultGuid() {
		return vaultGuid;
	}

	public void setVaultGuid(String vaultGuid) {
		this.vaultGuid = vaultGuid;
	}

}
