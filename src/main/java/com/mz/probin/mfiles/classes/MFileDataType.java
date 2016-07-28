package com.mz.probin.mfiles.classes;


public enum MFileDataType {

    Uninitialized(0),
    Text(1),
    Integer(2),
    Floating(3),
    Date(5),
    Time(6),
    Timestamp(7),
    Boolean(8),
    Lookup(9),
    MultiSelectLookup(10),
    Integer64(11),
    FILETIME(12),
    MultiLineText(13),
    ACL(14);

    private final int dataType;

    MFileDataType(int dataType) {
        this.dataType = dataType;
    }

    public int value() {
        return this.dataType;
    }
}
