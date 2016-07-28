package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class FolderContentItems implements Serializable {

    @JsonProperty("Path")
    private String path;

    @JsonProperty("MoreResults")
    private boolean moreResults;

    @JsonProperty("Items")
    private FolderContentItem[] items;

    public FolderContentItems() {
        this(null, false, null);
    }

    public FolderContentItems(String path, boolean moreResults, FolderContentItem[] items) {
        this.path = path;
        this.moreResults = moreResults;
        this.items = items;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isMoreResults() {
        return moreResults;
    }

    public void setMoreResults(boolean moreResults) {
        this.moreResults = moreResults;
    }

    public FolderContentItem[] getItems() {
        return items;
    }

    public void setItems(FolderContentItem[] items) {
        this.items = items;
    }
}
