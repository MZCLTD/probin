package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SessionInfo implements Serializable {

    @JsonProperty("AccountName")
    private String accountName;

    @JsonProperty("ACLMode")
    private int aclMode;

    @JsonProperty("MFAuthType")
    private int authenticationType;

    @JsonProperty("CanForceUndoCheckout")
    private boolean canForceUndoCheckout;

    @JsonProperty("CanManageCommonUISettings")
    private boolean canManageCommonUISettings;

    @JsonProperty("CanManageCommonViews")
    private boolean canManageCommonViews;

    @JsonProperty("CanManageTraditionalFolders")
    private boolean canManageTraditionalFolders;

    @JsonProperty("CanMaterializeViews")
    private boolean canMaterializeViews;

    @JsonProperty("CanSeeAllObjects")
    private boolean canSeeAllObjects;

    @JsonProperty("CanSeeDeletedObjects")
    private boolean canSeeDeletedObjects;

    @JsonProperty("InternalUser")
    private boolean internalUser;

    @JsonProperty("LicenseAllowsModifications")
    private boolean licenseAllowsModifications;

    @JsonProperty("UserID")
    private int userID;

    public SessionInfo() {}

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAclMode() {
        return aclMode;
    }

    public void setAclMode(int aclMode) {
        this.aclMode = aclMode;
    }

    public int getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(int authenticationType) {
        this.authenticationType = authenticationType;
    }

    public boolean isCanForceUndoCheckout() {
        return canForceUndoCheckout;
    }

    public void setCanForceUndoCheckout(boolean canForceUndoCheckout) {
        this.canForceUndoCheckout = canForceUndoCheckout;
    }

    public boolean isCanManageCommonUISettings() {
        return canManageCommonUISettings;
    }

    public void setCanManageCommonUISettings(boolean canManageCommonUISettings) {
        this.canManageCommonUISettings = canManageCommonUISettings;
    }

    public boolean isCanManageCommonViews() {
        return canManageCommonViews;
    }

    public void setCanManageCommonViews(boolean canManageCommonViews) {
        this.canManageCommonViews = canManageCommonViews;
    }

    public boolean isCanManageTraditionalFolders() {
        return canManageTraditionalFolders;
    }

    public void setCanManageTraditionalFolders(boolean canManageTraditionalFolders) {
        this.canManageTraditionalFolders = canManageTraditionalFolders;
    }

    public boolean isCanMaterializeViews() {
        return canMaterializeViews;
    }

    public void setCanMaterializeViews(boolean canMaterializeViews) {
        this.canMaterializeViews = canMaterializeViews;
    }

    public boolean isCanSeeAllObjects() {
        return canSeeAllObjects;
    }

    public void setCanSeeAllObjects(boolean canSeeAllObjects) {
        this.canSeeAllObjects = canSeeAllObjects;
    }

    public boolean isCanSeeDeletedObjects() {
        return canSeeDeletedObjects;
    }

    public void setCanSeeDeletedObjects(boolean canSeeDeletedObjects) {
        this.canSeeDeletedObjects = canSeeDeletedObjects;
    }

    public boolean isInternalUser() {
        return internalUser;
    }

    public void setInternalUser(boolean internalUser) {
        this.internalUser = internalUser;
    }

    public boolean isLicenseAllowsModifications() {
        return licenseAllowsModifications;
    }

    public void setLicenseAllowsModifications(boolean licenseAllowsModifications) {
        this.licenseAllowsModifications = licenseAllowsModifications;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
