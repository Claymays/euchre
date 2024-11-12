package com.mays.euchre.data;

import lombok.Data;

import java.util.List;

@Data
public class Team {
    private int           id;
    private List<Integer> score;
    private List<Player>  players;
}
