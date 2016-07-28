package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjType implements Serializable {

    @JsonProperty("ID")
    private int id;

    @JsonProperty("AllowAdding")
    private boolean allowAdding;

    @JsonProperty("CanHaveFiles")
    private boolean canHaveFiles;

    @JsonProperty("DefaultPropertyDef")
    private int defaultPropertyDef;

    @JsonProperty("External")
    private boolean external;

    @JsonProperty("NamePlural")
    private String namePlural;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("OwnerPropertyDef")
    private int ownerPropertyDef;

    @JsonProperty("ReadOnlyPropertiesDuringInsert")
    private int[] readOnlyPropertiesDuringInsert;

    @JsonProperty("ReadOnlyPropertiesDuringUpdate")
    private int[] readOnlyPropertiesDuringUpdate;

    @JsonProperty("RealObjectType")
    private boolean realObjectType;

    public ObjType() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAllowAdding() {
        return allowAdding;
    }

    public void setAllowAdding(boolean allowAdding) {
        this.allowAdding = allowAdding;
    }

    public boolean isCanHaveFiles() {
        return canHaveFiles;
    }

    public void setCanHaveFiles(boolean canHaveFiles) {
        this.canHaveFiles = canHaveFiles;
    }

    public int getDefaultPropertyDef() {
        return defaultPropertyDef;
    }

    public void setDefaultPropertyDef(int defaultPropertyDef) {
        this.defaultPropertyDef = defaultPropertyDef;
    }

    public boolean isExternal() {
        return external;
    }

    public void setExternal(boolean external) {
        this.external = external;
    }

    public String getNamePlural() {
        return namePlural;
    }

    public void setNamePlural(String namePlural) {
        this.namePlural = namePlural;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwnerPropertyDef() {
        return ownerPropertyDef;
    }

    public void setOwnerPropertyDef(int ownerPropertyDef) {
        this.ownerPropertyDef = ownerPropertyDef;
    }

    public int[] getReadOnlyPropertiesDuringInsert() {
        return readOnlyPropertiesDuringInsert;
    }

    public void setReadOnlyPropertiesDuringInsert(int[] readOnlyPropertiesDuringInsert) {
        this.readOnlyPropertiesDuringInsert = readOnlyPropertiesDuringInsert;
    }

    public int[] getReadOnlyPropertiesDuringUpdate() {
        return readOnlyPropertiesDuringUpdate;
    }

    public void setReadOnlyPropertiesDuringUpdate(int[] readOnlyPropertiesDuringUpdate) {
        this.readOnlyPropertiesDuringUpdate = readOnlyPropertiesDuringUpdate;
    }

    public boolean isRealObjectType() {
        return realObjectType;
    }

    public void setRealObjectType(boolean realObjectType) {
        this.realObjectType = realObjectType;
    }
}
