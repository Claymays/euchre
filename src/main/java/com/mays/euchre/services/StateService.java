package com.mays.euchre.services;

import com.mays.euchre.data.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateService {
    // TODO: Will need to be updated to be instantiated depending on game settings
    private static final int HAND_SIZE = 5;
    private static State     state;
    private final List<Card> deck;

    public State initilizeState(List<Team> teams) {
        state = new State();
        state.setTeams(teams);
        state.setActiveOrder(orderPlayers());
        return state;
    }

    public State deal() {
        var players = state.getActiveOrder();

        Collections.shuffle(deck);
        var from = 0;
        var to = HAND_SIZE;
        state.setKitty(deck.subList(from, HAND_SIZE -1));
        for (var player : players) {
            to += HAND_SIZE;
            from += HAND_SIZE;
            player.setHand(deck.subList(from, to));
        }
        state.setActiveOrder(players);
        return state;
    }

    public State callBid(Team bidder, Card card, Player dealer) {
        state.setTrump(card.suit());
        state.setBiddingTeam(bidder);
        state.setBid(3);
        dealer.getHand().add(card);
        return state;
    }

    public State playCard(Player player, Card card) {
        if (isActivePlayer(player)) {
            state.getPlayedCards().put(player, card);
            player.getHand().remove(card);
            state.getActiveOrder().remove(player);
            state.getActiveOrder().add(player);
        }
        return state;
    }

    private static boolean isActivePlayer(Player player) {
        return !state.getPlayedCards().containsKey(player) &&
                state.getActiveOrder().getFirst().equals(player);
    }

    private static void resolveTrick() {
        var trick = state.getPlayedCards().entrySet();
        var biddingTeam = state.getBiddingTeam();
        var winner = trick.stream().findFirst().orElse(null);

        if (winner != null) {
            var leadingSuit = winner.getValue().suit();
            for (var play : trick) {

                var winningRank = winner.getValue().rank().getValue();
                var winningSuit = winner.getValue().suit();
                var suit = play.getValue().suit();
                var rank = play.getValue().rank().getValue();


                // If played card is trump and has the highest rank you win
                if (suit.equals(state.getTrump()) && rank > winningRank) {
                    // If the played card matches lead suit and has higher rank, you win
                    winner = play;
                    continue;
                }
                if (winningSuit.equals(state.getTrump())) {
                    continue;
                }
                if (suit.equals(leadingSuit) && rank > winningRank) {
                    winner = play;
                }
            }
            if (biddingTeam.getPlayers().contains(winner.getKey())) {
                biddingTeam.setTricks(biddingTeam.getTricks() + 1);
            }
            while (!state.getActiveOrder().getFirst().equals(winner.getKey())) {
                state.getActiveOrder().add(state.getActiveOrder().getFirst());
                state.getActiveOrder().pop();
            }
        }

    }

//    private static boolean resolveHand() {
//        if (state.getBiddingTeam().getTricks() != state.getBid()) {
////            state.getBiddingTeam().setScores();
//        }
//        return state.getBiddingTeam().getTricks() >= state.getBid();
//    }

    private static LinkedList<Player> orderPlayers() {
        var players = new LinkedList<Player>();
        var teams = state.getTeams();
        var teamA = teams.get(0);
        var teamB = teams.get(1);
        players.add(teamA.getPlayerA());
        players.add(teamA.getPlayerB());
        players.add(teamB.getPlayerA());
        players.add(teamB.getPlayerB());
        return players;
    }

}
