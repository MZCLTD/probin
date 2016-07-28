package com.mz.probin.mfiles.classes;


public enum MFAuthType {

    Unknown(0),

    LoggedOnWindowsUser(1),

    SpecificWindowsUser(2),

    SpecificMFilesUser(3);

    private final int value;

    MFAuthType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
