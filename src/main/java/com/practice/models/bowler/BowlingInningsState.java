package com.practice.models.bowler;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BowlingInningsState {

    private Integer ballBowled;
    private Integer oversBowled;
    private Integer currentScore;
    private Integer wicketsTaken;
    private List<BowlerInningStat> bowlersStat;
    private Bowler currentBowler;
}
