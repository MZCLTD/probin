package com.mz.probin.mfiles.classes;


public enum MFACLMode {

    Simple(0),

    AutomaticPermissionsWithComponents(1);

    private final int value;

    MFACLMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
