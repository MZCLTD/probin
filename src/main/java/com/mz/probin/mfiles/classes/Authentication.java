package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("serial")
public class Authentication implements Serializable {

    @JsonProperty("Username")
    private String username;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("Domain")
    private String domain;

    @JsonProperty("WindowsUser")
    private boolean windowsUser;

    @JsonProperty("ComputerName")
    private String computerName;

    @JsonProperty("VaultGuid")
    private String vaultGuid;

    @JsonProperty("Expiration")
    private Date expiration;

    @JsonProperty("ReadOnly")
    private boolean readOnly;

    @JsonProperty("URL")
    private String url;

    @JsonProperty("Method")
    private String method;

    public Authentication() {}

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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean isWindowsUser() {
        return windowsUser;
    }

    public void setWindowsUser(boolean windowsUser) {
        this.windowsUser = windowsUser;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getVaultGuid() {
        return vaultGuid;
    }

    public void setVaultGuid(String vaultGuid) {
        this.vaultGuid = vaultGuid;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
