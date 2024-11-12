package com.mays.euchre.data;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
public class State {
    private int                bid;
    private Trump              trump;
    private List<Card>         kitty;
    private Player             active;
    private Team               biddingTeam;
    private LinkedList<Player> playerOrder;
    private Map<Player, Card>  playedCards;
    private final Integer      HAND_SIZE;

    public State(Integer handSize) {
        HAND_SIZE = handSize;
    }
    public boolean isActivePlayer(Player player) {
        var count = playedCards.keySet();
        var nextPlayer = playerOrder.subList(0, count.size()).getFirst();
        return !playedCards.containsKey(player) && nextPlayer.equals(player);
    }

    public void playCard(Player player, Card card) {
        playedCards.put(player, card);
    }

    public void resolveTrick() {

    }
}

enum Trump {
    SPADES,
    DIAMONDS,
    HEARTS,
    CLUBS,
    HIGH,
    LOW
}
