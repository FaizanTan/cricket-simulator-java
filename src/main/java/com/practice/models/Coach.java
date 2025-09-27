package com.practice.models;

import com.practice.enums.PlayingLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Coach extends Identifiable {

    private Map<Map<PlayingLevel, String>, Boolean> coachedTeams;
    private Team currentTeam;
}
