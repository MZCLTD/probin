package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectVersion implements Serializable {

    @JsonProperty("ObjectGUID")
    private String objectGuid;

    //yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z")
    @JsonProperty("AccessedByMeUtc")
    private Date accessedByMeUtc;

    @JsonProperty("CheckedOutAtUtc")
    private Date checkedOutAtUtc;

    @JsonProperty("CheckedOutTo")
    private int checkedOutTo;

    @JsonProperty("CheckedOutToUserName")
    private String checkedOutToUserName;

    @JsonProperty("Class")
    private int objectClass;

    @JsonProperty("CreatedUtc")
    private Date createdUtc;

    @JsonProperty("Deleted")
    private boolean deleted;

    @JsonProperty("DisplayID")
    private String displayId;

    @JsonProperty("Files")
    private ObjectFile[] files;

    @JsonProperty("HasAssignments")
    private boolean hasAssignments;

    @JsonProperty("HasRelationshipsFromThis")
    private boolean hasRelationshipsFromThis;

    @JsonProperty("HasRelationshipsToThis")
    private boolean hasRelationshipsToThis;

    @JsonProperty("IsStub")
    private boolean stub;

    @JsonProperty("LastModifiedUtc")
    private Date lastModifiedUtc;

    @JsonProperty("ObjectCheckedOut")
    private boolean objectCheckedOut;

    @JsonProperty("ObjectCheckedOutToThisUser")
    private boolean objectCheckedOutToThisUser;

    @JsonProperty("ObjectVersionFlags")
    private int objectVersionFlags;

    @JsonProperty("ObjVer")
    private ObjVer objVer;

    @JsonProperty("SingleFile")
    private boolean singleFile;

    @JsonProperty("ThisVersionLatestToThisUser")
    private boolean thisVersionLatestToThisUser;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("VisibleAfterOperation")
    private boolean visibleAfterOperation;

    //Error related fields
    @JsonProperty("Exception")
    private ExceptionInfo exception;

    @JsonProperty("ErrorCode")
    private int errorCode;

    @JsonProperty("Status")
    private int status;

    @JsonProperty("Method")
    private String method;



    public ObjectVersion() {}

    public String getObjectGuid() {
        return objectGuid;
    }

    public void setObjectGuid(String objectGuid) {
        this.objectGuid = objectGuid;
    }

    public Date getAccessedByMeUtc() {
        return accessedByMeUtc;
    }

    public void setAccessedByMeUtc(Date accessedByMeUtc) {
        this.accessedByMeUtc = accessedByMeUtc;
    }

    public Date getCheckedOutAtUtc() {
        return checkedOutAtUtc;
    }

    public void setCheckedOutAtUtc(Date checkedOutAtUtc) {
        this.checkedOutAtUtc = checkedOutAtUtc;
    }

    public int getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(int checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public String getCheckedOutToUserName() {
        return checkedOutToUserName;
    }

    public void setCheckedOutToUserName(String checkedOutToUserName) {
        this.checkedOutToUserName = checkedOutToUserName;
    }

    public int getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(int objectClass) {
        this.objectClass = objectClass;
    }

    public Date getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(Date createdUtc) {
        this.createdUtc = createdUtc;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDisplayId() {
        return displayId;
    }

    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    public ObjectFile[] getFiles() {
        return files;
    }

    public void setFiles(ObjectFile[] files) {
        this.files = files;
    }

    public boolean isHasAssignments() {
        return hasAssignments;
    }

    public void setHasAssignments(boolean hasAssignments) {
        this.hasAssignments = hasAssignments;
    }

    public boolean isHasRelationshipsFromThis() {
        return hasRelationshipsFromThis;
    }

    public void setHasRelationshipsFromThis(boolean hasRelationshipsFromThis) {
        this.hasRelationshipsFromThis = hasRelationshipsFromThis;
    }

    public boolean isHasRelationshipsToThis() {
        return hasRelationshipsToThis;
    }

    public void setHasRelationshipsToThis(boolean hasRelationshipsToThis) {
        this.hasRelationshipsToThis = hasRelationshipsToThis;
    }

    public boolean isStub() {
        return stub;
    }

    public void setStub(boolean stub) {
        this.stub = stub;
    }

    public Date getLastModifiedUtc() {
        return lastModifiedUtc;
    }

    public void setLastModifiedUtc(Date lastModifiedUtc) {
        this.lastModifiedUtc = lastModifiedUtc;
    }

    public boolean isObjectCheckedOut() {
        return objectCheckedOut;
    }

    public void setObjectCheckedOut(boolean objectCheckedOut) {
        this.objectCheckedOut = objectCheckedOut;
    }

    public boolean isObjectCheckedOutToThisUser() {
        return objectCheckedOutToThisUser;
    }

    public void setObjectCheckedOutToThisUser(boolean objectCheckedOutToThisUser) {
        this.objectCheckedOutToThisUser = objectCheckedOutToThisUser;
    }

    public int getObjectVersionFlags() {
        return objectVersionFlags;
    }

    public void setObjectVersionFlags(int objectVersionFlags) {
        this.objectVersionFlags = objectVersionFlags;
    }

    public ObjVer getObjVer() {
        return objVer;
    }

    public void setObjVer(ObjVer objVer) {
        this.objVer = objVer;
    }

    public boolean isSingleFile() {
        return singleFile;
    }

    public void setSingleFile(boolean singleFile) {
        this.singleFile = singleFile;
    }

    public boolean isThisVersionLatestToThisUser() {
        return thisVersionLatestToThisUser;
    }

    public void setThisVersionLatestToThisUser(boolean thisVersionLatestToThisUser) {
        this.thisVersionLatestToThisUser = thisVersionLatestToThisUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVisibleAfterOperation() {
        return visibleAfterOperation;
    }

    public void setVisibleAfterOperation(boolean visibleAfterOperation) {
        this.visibleAfterOperation = visibleAfterOperation;
    }

    public ExceptionInfo getException() {
        return exception;
    }

    public void setException(ExceptionInfo exception) {
        this.exception = exception;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isHasErrors() {
        return getException() != null && getErrorCode() > 0;
    }
}
