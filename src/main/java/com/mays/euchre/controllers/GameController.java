package com.mays.euchre.controllers;

import com.mays.euchre.data.Game;
import com.mays.euchre.data.Player;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/game")
public class GameController {
    private static Game game;

    public GameController() {
        game = new Game();
    }

    @PostMapping("/join")
    public void join(@RequestBody Player player) {
        if (!game.getPlayers().contains(player) || game.getPlayers().size() > 4) {
            game.getPlayers().add(player);
        }
    }

    @PostMapping("/new")
    public void newGame() {
        game = new Game();
    }

    public static void updateTeams() {
        game.updateTeams();
    }

}
