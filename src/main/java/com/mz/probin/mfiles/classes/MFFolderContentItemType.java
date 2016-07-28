package com.mz.probin.mfiles.classes;


public enum MFFolderContentItemType {

    Unknown(0),

    ViewFolder(1),

    PropertyFolder(2),

    TraditionalFolder(3),

    ObjectVersion(4);

    private final int value;

    MFFolderContentItemType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
