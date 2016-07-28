package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class ValueListItem implements Serializable {

    @JsonProperty("ID")
    private int id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("DisplayID")
    private String displayID;

    @JsonProperty("HasOwner")
    private boolean hasOwner;

    @JsonProperty("HasParent")
    private boolean hasParent;

    @JsonProperty("OwnerID")
    private int ownerId;

    @JsonProperty("ParentID")
    private int parentId;

    @JsonProperty("ValueListID")
    private int valueListId;

    public ValueListItem() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayID() {
        return displayID;
    }

    public void setDisplayID(String displayID) {
        this.displayID = displayID;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public boolean isHasParent() {
        return hasParent;
    }

    public void setHasParent(boolean hasParent) {
        this.hasParent = hasParent;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getValueListId() {
        return valueListId;
    }

    public void setValueListId(int valueListId) {
        this.valueListId = valueListId;
    }
}
