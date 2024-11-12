package com.mays.euchre.config;

import com.mays.euchre.data.Card;
import com.mays.euchre.data.Rank;
import com.mays.euchre.data.Suit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<Card> deck() {
        var deck = new ArrayList<Card>();
        for (var suit : Suit.values()) {
            for (var rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }
}
