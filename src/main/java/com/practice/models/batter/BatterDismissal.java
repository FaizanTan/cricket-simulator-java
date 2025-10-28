package com.practice.models.batter;

import com.practice.enums.BatterDismissalStyle;
import com.practice.models.CricketPlayer;
import com.practice.models.WicketKeeper;
import com.practice.models.bowler.Bowler;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatterDismissal {

    private Bowler bowledBy;
    private WicketKeeper stumpedBy;
    private CricketPlayer caughtBy;
    private CricketPlayer runoutBy;
    private BatterDismissalStyle dismissalStyle;

}
