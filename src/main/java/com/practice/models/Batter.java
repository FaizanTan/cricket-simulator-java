package com.practice.models;
import com.practice.interfaces.BatterInterface;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Batter extends CricketPlayer implements BatterInterface {

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
    public void playShot() {

    }

    @Override
    public void runBetweenWickets(Integer runs) {

    }
}
