package com.practice.models.bowler;

import com.practice.models.batter.BatterInningStat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BowlerInningStat {

    private Bowler bowler;
    private Integer ballsBowled;
    private Integer wicketsTaken;
    private Integer runsConceded;
    private Integer maidenOvers;
    private Integer numberOfNoBalls;
    private Integer numberOfWideBalls;
    private List<BatterInningStat> wickets;

}
