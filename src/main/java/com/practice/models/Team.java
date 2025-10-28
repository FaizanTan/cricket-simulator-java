package com.practice.models;

import com.practice.enums.PlayingLevel;
import com.practice.managers.TeamManager;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Team extends Identifiable {

    private String teamName;
    private PlayingLevel playingLevel;
    private Coach coach;
    private Long captainPlayerId;
    private Set<CricketPlayer> players;
    private TeamManager manager;

}
