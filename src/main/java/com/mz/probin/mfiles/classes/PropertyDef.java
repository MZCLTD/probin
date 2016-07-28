package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@SuppressWarnings({"serial"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyDef implements Serializable {

    @JsonProperty("ID")
    private int id;

    @JsonProperty("AllObjectTypes")
    private boolean allObjectTypes;

    @JsonProperty("AutomaticValue")
    private String automaticValue;

    @JsonProperty("AutomaticValueType")
    private int automaticValueType;

    @JsonProperty("BasedOnValueList")
    private boolean basedOnValueList;

    @JsonProperty("DataType")
    private int dataType;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("ObjectType")
    private int objectType;

    @JsonProperty("ValueList")
    private int valueList;


    public PropertyDef() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAllObjectTypes() {
        return allObjectTypes;
    }

    public void setAllObjectTypes(boolean allObjectTypes) {
        this.allObjectTypes = allObjectTypes;
    }

    public String getAutomaticValue() {
        return automaticValue;
    }

    public void setAutomaticValue(String automaticValue) {
        this.automaticValue = automaticValue;
    }

    public int getAutomaticValueType() {
        return automaticValueType;
    }

    public void setAutomaticValueType(int automaticValueType) {
        this.automaticValueType = automaticValueType;
    }

    public boolean isBasedOnValueList() {
        return basedOnValueList;
    }

    public void setBasedOnValueList(boolean basedOnValueList) {
        this.basedOnValueList = basedOnValueList;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getObjectType() {
        return objectType;
    }

    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }

    public int getValueList() {
        return valueList;
    }

    public void setValueList(int valueList) {
        this.valueList = valueList;
    }
}
