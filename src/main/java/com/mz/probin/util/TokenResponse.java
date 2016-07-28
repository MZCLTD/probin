package com.mz.probin.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponse {

	@JsonProperty(value = "Value")
	private String token;
	
	public TokenResponse() {}
	
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

