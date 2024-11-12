package com.mays.euchre.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Game {
    private int          gameId;
    private List<Team>   teams;
    private State        state;
    private boolean      completed;
    private List<Player> players;

    public void updateTeams() {
        Collections.shuffle(players);
        var team1 = teams.getFirst();
        var team2 = teams.getLast();
        team1.setPlayers(players.subList(0, 2));
        team2.setPlayers(players.subList(2, 4));
        var updated = new ArrayList<Team>();
        updated.add(team1);
        updated.add(team2);
        setTeams(updated);
    }
}
