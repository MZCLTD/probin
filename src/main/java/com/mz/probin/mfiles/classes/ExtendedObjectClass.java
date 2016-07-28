package com.mz.probin.mfiles.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@SuppressWarnings("serial")
public class ExtendedObjectClass implements Serializable {

    @JsonProperty("AssociatedPropertyDefs")
    private AssociatedPropertyDef[] associatedPropertyDefs;

    @JsonProperty("Templates")
    private ObjectVersion[] templates;

    public ExtendedObjectClass() {
        this(null, null);
    }

    public ExtendedObjectClass(AssociatedPropertyDef[] associatedPropertyDefs, ObjectVersion[] templates) {
        this.associatedPropertyDefs = associatedPropertyDefs;
        this.templates = templates;
    }

    public AssociatedPropertyDef[] getAssociatedPropertyDefs() {
        return associatedPropertyDefs;
    }

    public void setAssociatedPropertyDefs(AssociatedPropertyDef[] associatedPropertyDefs) {
        this.associatedPropertyDefs = associatedPropertyDefs;
    }

    public ObjectVersion[] getTemplates() {
        return templates;
    }

    public void setTemplates(ObjectVersion[] templates) {
        this.templates = templates;
    }
}
