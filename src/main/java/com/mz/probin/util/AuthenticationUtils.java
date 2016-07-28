package com.mz.probin.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mz.probin.constants.Constants;
import com.mz.probin.mfiles.classes.MFilesUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AuthenticationUtils {
	
	public static String getAuthenticationToken( MFilesUser mfilesUser, String authTokenUrl ) throws JsonProcessingException {
		HttpEntity<MFilesUser> request = new HttpEntity<>(mfilesUser);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<TokenResponse> response = restTemplate.exchange(authTokenUrl, HttpMethod.POST, request, TokenResponse.class);
		
		TokenResponse tokenResponse = response.getBody();
		
        return (tokenResponse == null) ? "" : tokenResponse.getToken();
	}
	
	public static String getAuthenticationToken( String authTokenUrl ) throws JsonProcessingException {
		return getAuthenticationToken(getDefaultMFilesUser(), authTokenUrl);
	}
	
	public static String getAuthenticationToken() throws JsonProcessingException {
		return getAuthenticationToken(getDefaultMFilesUser(), Constants.HOST + Constants.AUTHENTICATION_URL);
	}
	
	public static MFilesUser getDefaultMFilesUser() {
		MFilesUser user = new MFilesUser();
		user.setPassword(Constants.PASSWORD);
		user.setUsername(Constants.USERNAME);
		user.setVaultGuid(Constants.VAULTGUID);
		
		return user;
	}
}
