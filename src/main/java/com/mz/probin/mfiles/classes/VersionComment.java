package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class VersionComment implements Serializable {

    @JsonProperty("LastModifiedBy")
    private PropertyValue lastModifiedBy;

    @JsonProperty("StatusChanged")
    private PropertyValue statusChanged;

    @JsonProperty("Comment")
    private PropertyValue comment;

    @JsonProperty("ObjVer")
    private ObjVer objVer;

    public VersionComment() {}

    public ObjVer getObjVer() {
        return objVer;
    }

    public void setObjVer(ObjVer objVer) {
        this.objVer = objVer;
    }

    public PropertyValue getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(PropertyValue lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public PropertyValue getStatusChanged() {
        return statusChanged;
    }

    public void setStatusChanged(PropertyValue statusChanged) {
        this.statusChanged = statusChanged;
    }

    public PropertyValue getComment() {
        return comment;
    }

    public void setComment(PropertyValue comment) {
        this.comment = comment;
    }
}
