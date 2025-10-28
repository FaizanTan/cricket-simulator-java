package com.practice.models.batter;

import com.practice.enums.BatterDismissalStyle;
import com.practice.models.CricketPlayer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatterInningStat {

    private Batter batter;
    private Integer runsScored;
    private Integer ballsPlayed;
    private Integer fours;
    private Integer sixes;
    private Integer twos;
    private Integer threes;
    private Integer singles;
    private Integer dots;
    private BatterDismissal dismissal;

}
