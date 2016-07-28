package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectFile implements Serializable {

    @JsonProperty("ChangeTimeUtc")
    private Date changeTimeUtc;

    @JsonProperty("Extension")
    private String extension;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Version")
    private int version;

    @JsonProperty("EscapedName")
    private String escapedName;

    @JsonProperty("LastModified")
    private Date lastModified;

    @JsonProperty("Size")
    private int size;

    @JsonProperty("FileGUID")
    private String fileGuid;

    @JsonProperty("ID")
    private int id;

    public ObjectFile() {}

    public Date getChangeTimeUtc() {
        return changeTimeUtc;
    }

    public void setChangeTimeUtc(Date changeTimeUtc) {
        this.changeTimeUtc = changeTimeUtc;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getEscapedName() {
        return escapedName;
    }

    public void setEscapedName(String escapedName) {
        this.escapedName = escapedName;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFileGuid() {
        return fileGuid;
    }

    public void setFileGuid(String fileGuid) {
        this.fileGuid = fileGuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
