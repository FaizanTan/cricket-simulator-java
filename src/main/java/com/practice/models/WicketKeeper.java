package com.practice.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class WicketKeeper extends CricketPlayer {

    private Batter batterPart;

    private Map<Integer, Integer> stumpingsPerMatch;
    private Map<Integer, Integer> catchesPerMatch;

    public void stump() {}

    public void catchBowl() {}

    public Integer getTotalDismissals() {
        return getTotalStumping() + getTotalCatches();
    }

    public Integer getTotalStumping() {
        return stumpingsPerMatch.values().stream().reduce(0, Integer::sum);
    }

    public Integer getTotalCatches() {
        return catchesPerMatch.values().stream().reduce(0, Integer::sum);
    }
}
