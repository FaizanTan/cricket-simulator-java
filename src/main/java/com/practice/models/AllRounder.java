package com.practice.models;

import com.practice.interfaces.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AllRounder extends CricketPlayer implements BatterInterface, BowlerInterface {

    private Batter batterPart;
    private Bowler bowlerPart;

    @Override
    public void playShot() {
        batterPart.playShot();
    }

    @Override
    public void runBetweenWickets(Integer runs) {

    }

    @Override
    public void bowl() {
        bowlerPart.bowl();
    }
}
