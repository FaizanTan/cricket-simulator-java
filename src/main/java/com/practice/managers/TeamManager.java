package com.practice.managers;

import com.practice.enums.PlayingLevel;
import com.practice.models.Coach;
import com.practice.models.CricketPlayer;
import com.practice.models.Identifiable;
import com.practice.models.Team;
import com.practice.utils.identity.IdValidator;
import java.util.*;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamManager extends Identifiable {

    private String name;
    private Set<Team> managedTeams;
    private Set<Team> resignedTeams;
    private Team managedTeam;

    public void removePlayer(Long playerId) {
        if(null == playerId || null == managedTeam) return;

        Set<CricketPlayer> updatedPlayers = managedTeam.getPlayers()
                .stream()
                .filter(p -> !p.getId().equals(playerId))
                .collect(Collectors.toSet());

        managedTeam.setPlayers(updatedPlayers);
    }
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

        coach.setCurrentTeam(managedTeam);
        managedTeam.setCoach(coach);
    }
    public Boolean resignFromTeamWithId(Long teamId) {
        if (teamId == null || managedTeams == null || managedTeams.isEmpty()) {
            return null;
        }

        Optional<Team> team = managedTeams.stream()
                .filter(t -> Objects.equals(t.getId(), teamId))
                .findFirst();

        if (team.isEmpty()) {
            System.out.println("You are not managing this team.");
            return false;
        }

        boolean isValidTeam = IdValidator.validateIdInContext(Team.class.getSimpleName(), teamId);
        if (!isValidTeam) {
            System.out.println("Team does not exist.");
            return false;
        }

        team.get().setManager(null);
        managedTeams.remove(team.get());
        resignedTeams.add(team.get());

        return true;
    }
    public Boolean resignFromAllTeamsAtLevel(PlayingLevel level) {

        Set<Team> teamsAtLevel = managedTeams.stream()
                .filter(t -> t.getPlayingLevel().equals(level))
                .collect(Collectors.toSet());

        if (teamsAtLevel == null || teamsAtLevel.isEmpty()) {
            System.out.println("Not managing any team at this level.");
            return false;
        }

        teamsAtLevel.forEach(t -> {
            t.setManager(null);
            managedTeams.remove(t);
            resignedTeams.add(t);
        });

        return true;
    }

}
