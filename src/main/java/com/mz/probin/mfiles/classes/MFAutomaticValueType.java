package com.mz.probin.mfiles.classes;

/**
 * Created by emmanuel on 7/15/16.
 */
public enum MFAutomaticValueType {

    None(0),

    CalculateWithPlacehoders(1),

    CalculateWithVBScript(2),

    AutoNumberSimple(3),

    WithVBScript(4);

    private final int value;

    MFAutomaticValueType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
