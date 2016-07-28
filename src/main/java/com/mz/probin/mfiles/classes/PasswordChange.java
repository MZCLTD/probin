package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class PasswordChange implements Serializable {

    @JsonProperty("OldPassword")
    private String oldPassword;

    @JsonProperty("NewPassword")
    private String newPassword;

    public PasswordChange() {
        this(null, null);
    }

    public PasswordChange(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
