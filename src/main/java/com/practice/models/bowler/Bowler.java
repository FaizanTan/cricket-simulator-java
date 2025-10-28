package com.practice.models.bowler;

import com.practice.enums.BowlType;
import com.practice.interfaces.IBowler;
import com.practice.models.CricketPlayer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class Bowler extends CricketPlayer implements IBowler {

    private Integer totalWickets;
    private Double average;
    private Double economyRate;
    private Integer matchesPlayed;
    private Integer inningsBowled;
    private Integer oversBowled;
    private Integer runsConceded;

    @Override
    public BowlType selectBowlType(Set<BowlType> availableBowlTypes) {
        return null;
    }

    @Override
    public void bowl(BowlType btype) {

    }

    @Override
    public void celebrateWicket() {

    }

    @Override
    public void askForReview() {

    }

    @Override
    public void celebrateHaul(Integer wickets) {

    }
}
