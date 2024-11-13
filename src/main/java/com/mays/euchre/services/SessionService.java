package com.mays.euchre.services;

import com.mays.euchre.data.Session;
import com.mays.euchre.data.Player;
import com.mays.euchre.data.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service

public class SessionService {
    private static Session session;
    private StateService stateService;

    @Autowired
    public SessionService(StateService stateService) {
        session = new Session();
        this.stateService = stateService;
    }

    public Session joinSession(int sessionId, Player player) {
        if (!session.getPlayers().contains(player) &&
             session.getPlayers().size() < 4 &&
             session.getSessionId() == sessionId) {
            session.getPlayers().add(player);
        }
        return session;
    }

    public Session newGame() {
        session = new Session();
        return session;
    }

    public Session start(List<Player> players) {
        var teams = setTeams(players);
        var state = stateService.initilizeState(teams);
        session.setState(state);
        return session;
    }

    private List<Team> setTeams(List<Player> players) {
        Collections.shuffle(players);
        var teams = new ArrayList<Team>();
        teams.add(new Team(players.get(0), players.get(1)));
        teams.add(new Team(players.get(2), players.get(3)));
        return teams;
    }
}
