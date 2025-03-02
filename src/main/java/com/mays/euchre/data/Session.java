package com.mays.euchre.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Session {
    private int          sessionId;
    private List<Team>   teams;
    private State        state;
    private boolean      completed;
    private List<Player> players;

    public Session() {
        this.sessionId = (int) (Math.random() * Integer.MAX_VALUE) + 1;
        this.completed = false;
        this.players = new ArrayList<>();
        this.teams = new ArrayList<>();
        this.state = new State();
    }

    public Session addPlayer(String name) {
        this.players.add(new Player(name));
        return this;
    }
}
