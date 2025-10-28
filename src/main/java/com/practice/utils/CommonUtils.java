package com.practice.utils;

public class CommonUtils {

    public static Double getOversFromBalls(Integer balls) {
        if (balls == null) return null;

        int completeOvers = balls / 6;
        int ballsLeft = balls % 6;

        return completeOvers + ballsLeft / 6.0;
    }

    public static String getOversRepresentation(Integer balls) {
        if (balls == null) return null;

        int completeOvers = balls / 6;
        int ballsLeft = balls % 6;

        return completeOvers + "." + ballsLeft;
    }

}
