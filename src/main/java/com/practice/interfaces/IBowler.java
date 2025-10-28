package com.practice.interfaces;

import com.practice.enums.BowlType;

import java.util.Set;

public interface IBowler {
    BowlType selectBowlType(Set<BowlType> availableBowlTypes);
    void bowl(BowlType bowlType);
    void celebrateWicket();
    void askForReview();
    void celebrateHaul(Integer wickets);
}
