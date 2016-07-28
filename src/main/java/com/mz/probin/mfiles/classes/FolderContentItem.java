package com.mz.probin.mfiles.classes;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FolderContentItem implements Serializable {

    @JsonProperty("FolderContentItemType")
    private int folderContentItemType;

    @JsonProperty("ObjectVersion")
    private ObjectVersion objectVersion;

    @JsonProperty("PropertyFolder")
    private TypedValue propertyFolder;

    @JsonProperty("TraditionalFolder")
    private Lookup traditionalFolder;

    @JsonProperty("View")
    private View view;

    public FolderContentItem() {}

    public int getFolderContentItemType() {
        return folderContentItemType;
    }

    public void setFolderContentItemType(int folderContentItemType) {
        this.folderContentItemType = folderContentItemType;
    }

    public ObjectVersion getObjectVersion() {
        return objectVersion;
    }

    public void setObjectVersion(ObjectVersion objectVersion) {
        this.objectVersion = objectVersion;
    }

    public TypedValue getPropertyFolder() {
        return propertyFolder;
    }

    public void setPropertyFolder(TypedValue propertyFolder) {
        this.propertyFolder = propertyFolder;
    }

    public Lookup getTraditionalFolder() {
        return traditionalFolder;
    }

    public void setTraditionalFolder(Lookup traditionalFolder) {
        this.traditionalFolder = traditionalFolder;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
