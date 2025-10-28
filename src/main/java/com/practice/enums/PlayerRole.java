package com.practice.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Set;

@Getter
public enum PlayerRole {
    CAPTAIN("C"),
    WICKET_KEEPER("WK"),
    BATTER("BAT"),
    BOWLER("BOWL"),
    ALL_ROUNDER("AR");

    private String value;

    PlayerRole(String val) {
        if(val == null || val.isEmpty()) {
            throw new IllegalArgumentException("PlayerRole value cannot be null or empty");
        }
        if(isValidKey(val)) {
            throw new IllegalArgumentException("Invalid PlayerRole value: " + val);
        }
        this.value = val;
    }

    public static boolean isValidKey(String key) {
        return Arrays.stream(PlayerRole.values())
                     .map(PlayerRole::getValue)
                     .toList()
                     .contains(key);
    }
}
