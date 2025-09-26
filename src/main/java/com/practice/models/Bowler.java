package com.practice.models;

import com.practice.interfaces.BowlerInterface;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Bowler extends CricketPlayer implements BowlerInterface {

    private Integer totalWickets;
    private Double average;
    private Double economyRate;
    private Integer matchesPlayed;
    private Integer inningsBowled;
    private Integer oversBowled;
    private Integer runsConceded;


    @Override
    public void bowl() {

    }
}
