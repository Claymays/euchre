package com.mays.euchre.controllers;

import com.mays.euchre.data.Session;
import com.mays.euchre.data.Player;
import com.mays.euchre.services.SessionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/session")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/{sessionId}/join")
    public Session join(@PathVariable int sessionId, @RequestBody Player player) {
        return sessionService.joinSession(sessionId, player);
    }

    @PostMapping("/new")
    public Session newGame() {
        return sessionService.newGame();
    }

    @PostMapping("/start")
    public Session startGame(@RequestBody List<Player> players) {
        return sessionService.start(players);
    }
}
