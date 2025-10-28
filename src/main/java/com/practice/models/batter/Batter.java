package com.practice.models.batter;
import com.practice.enums.Shot;
import com.practice.interfaces.IBatter;
import com.practice.models.CricketPlayer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class Batter extends CricketPlayer implements IBatter {

    private Integer totalRuns;
    private Integer totalFours;
    private Integer totalSixes;
    private Double strikeRate;
    private Double average;
    private Integer matchesPlayed;
    private Integer inningsPlayed;
    private Integer notOuts;
    private Integer highestScore;
    private Integer ballsFaced;
    private Integer hundreds;
    private Integer fifties;

    @Override
    public Shot selectShot(Set<Shot> availableShots) {
        return null;
    }

    @Override
    public void playShot(Shot shot) {}

    @Override
    public void runBetweenWickets(Integer runs) {}

    @Override
    public void celebrateRuns(Integer runs) {}

    @Override
    public void askForReview() {}
}
