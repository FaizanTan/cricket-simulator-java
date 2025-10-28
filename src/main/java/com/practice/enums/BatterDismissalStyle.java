package com.practice.enums;

public enum BatterDismissalStyle {

    BOWLED("BLD"),
    CAUGHT("C"),
    RUNOUT("RO"),
    LBW("LBW"),
    STUMPED("STMPD");

    private String value;

    BatterDismissalStyle(String value) {
        this.value = value;
    }

}
