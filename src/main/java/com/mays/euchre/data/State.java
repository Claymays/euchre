package com.mays.euchre.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
public class State {
    private int                bid;
    private Suit               trump;
    private List<Card>         kitty;
    private Player             active;
    private List<Team>         teams;
    private Player             dealer;
    private Team               biddingTeam;
    private Map<Player, Card>  playedCards;
    private LinkedList<Player> activeOrder;
    private LinkedList<Player> playerOrder;
}
