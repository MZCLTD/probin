package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class ViewLocation implements Serializable {

    @JsonProperty("OverlappedFolder")
    private TypedValue overlappedFolder;

    @JsonProperty("Overlapping")
    private boolean overlapping;

    public ViewLocation() {}

    public TypedValue getOverlappedFolder() {
        return overlappedFolder;
    }

    public void setOverlappedFolder(TypedValue overlappedFolder) {
        this.overlappedFolder = overlappedFolder;
    }

    public boolean isOverlapping() {
        return overlapping;
    }

    public void setOverlapping(boolean overlapping) {
        this.overlapping = overlapping;
    }
}
