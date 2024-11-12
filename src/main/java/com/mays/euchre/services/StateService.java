package com.mays.euchre.services;

import com.mays.euchre.data.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {
    private final List<Card> deck;
    // TODO: Will need to be updated to be instantiated depending on game settings
//    private static final int        HAND_SIZE = 5;

    public State playCard(Player player, Card card) {
        if (state.isActivePlayer(player)) {
            state.playCard(player, card);
        }
        return state;
    }

    public State deal(State state) {
        var players = state.getPlayerOrder();

        Collections.shuffle(deck);
        var from = 0;
        var to = HAND_SIZE;
        state.setKitty(deck.subList(from, HAND_SIZE -1));
        for (var player : players) {
            to += HAND_SIZE;
            from += HAND_SIZE;
            player.setHand(deck.subList(from, to));
        }
        Collections.shuffle(players);
        state.setPlayerOrder(players);
        return state;
    }
}
