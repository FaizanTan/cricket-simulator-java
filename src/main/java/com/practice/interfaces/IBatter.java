package com.practice.interfaces;

import com.practice.enums.Shot;
import java.util.Set;

public interface IBatter {

    Shot selectShot(Set<Shot> availableShots);
    void playShot(Shot shot);
    void runBetweenWickets(Integer runs);
    void celebrateRuns(Integer runs);
    void askForReview();
}
