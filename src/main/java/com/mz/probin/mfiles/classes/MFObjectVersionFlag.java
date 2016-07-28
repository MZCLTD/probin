package com.mz.probin.mfiles.classes;


public enum MFObjectVersionFlag {

    None(0),

    Completed(1),

    HasRelatedObjects(2);

    private final int value;

    MFObjectVersionFlag(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
