package com.practice.models;

import com.practice.enums.BowlType;
import com.practice.enums.Shot;
import com.practice.interfaces.*;
import com.practice.models.batter.Batter;
import com.practice.models.bowler.Bowler;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class AllRounder extends CricketPlayer implements IBatter, IBowler {

    private Batter batterPart;
    private Bowler bowlerPart;

    @Override
    public Shot selectShot(Set<Shot> availableShots) {
        return batterPart.selectShot(availableShots);
    }

    @Override
    public void playShot(Shot type) {
        batterPart.playShot(type);
    }

    @Override
    public void runBetweenWickets(Integer runs) {
        batterPart.runBetweenWickets(runs);
    }

    @Override
    public void celebrateRuns(Integer runs) {
        batterPart.celebrateRuns(runs);
    }

    @Override
    public void askForReview() {
        batterPart.askForReview();
    }

    @Override
    public void celebrateHaul(Integer wickets) {
        bowlerPart.celebrateHaul(wickets);
    }

    @Override
    public BowlType selectBowlType(Set<BowlType> availableBowlTypes) {
        return null;
    }

    @Override
    public void bowl(BowlType btype) {
        bowlerPart.bowl(btype);
    }

    @Override
    public void celebrateWicket() {
        bowlerPart.celebrateWicket();
    }
}
