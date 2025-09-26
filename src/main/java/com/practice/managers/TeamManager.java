package com.practice.managers;

import com.practice.enums.PlayingLevel;
import com.practice.models.Coach;
import com.practice.models.CricketPlayer;
import com.practice.models.Identifiable;
import com.practice.models.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class TeamManager extends Identifiable {
    private String name;
    private Team managedTeam;

    public void appointTeamCaptain(Long playerId) {
        if(null == playerId || null == managedTeam) return;

        CricketPlayer player = managedTeam.getPlayers().stream().filter(p -> p.getId().equals(playerId)).toList().getFirst();

        if(null == player) return;

        CricketPlayer existingCaptain = managedTeam.getPlayers().stream().filter(p -> p.getCaptainedTeams().containsKey(managedTeam.getTeamName()) && p.getCaptainedTeams().get(managedTeam.getTeamName())).toList().getFirst();

        if(null != existingCaptain) {
            existingCaptain.getCaptainedTeams().put(managedTeam.getTeamName(), false);
        }

        player.getCaptainedTeams().put(managedTeam.getTeamName(), true);

        managedTeam.setCaptainPlayerId(playerId);
    }

    public void appointCoach(Coach coach) {
        if(null == coach || null == managedTeam) return;

        Coach existingCoach = managedTeam.getCoach();

        if(null != existingCoach) {
            existingCoach.getCoachedTeams().put(Map.of(managedTeam.getPlayingLevel(), managedTeam.getTeamName()), true);
        }

        coach.setCoachingTeam(managedTeam);
        managedTeam.setCoach(coach);
    }
}
