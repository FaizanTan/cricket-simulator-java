package com.practice.models;

import com.practice.enums.*;
import lombok.Getter;

import java.util.Map;
import java.util.Set;

@Getter
public abstract class CricketPlayer extends Identifiable {

    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String email;;
    private PlayingLevel playingLevel;

    private PlayingHand playingHand;
    private Map<PlayingLevel, String> teamsMap;
    private Map<String, Boolean> captainedTeams;
}
