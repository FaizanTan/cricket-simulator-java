package com.practice.models.batter;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BattingInningsState {

    private Integer ballsPlayed;
    private Integer currentScore;
    private Integer wicketsFell;
    private Float averagePerOver;
    private Integer extras;
    private List<BatterInningStat> battersStat;

}
