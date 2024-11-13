package com.mays.euchre.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Team {
    private Player        playerA;
    private Player        playerB;
    private int           tricks;
    private List<Integer> scores;

    public Team(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.scores = new ArrayList<>();
        this.tricks = 0;
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(playerA);
        players.add(playerB);
        return players;
    }
}
