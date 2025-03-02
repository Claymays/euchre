package com.mays.euchre.data;

import lombok.Data;

import java.util.List;

@Data
public class Player {
    private int          id;
    private List<Card>   hand;
    private String       name;

    public Player(String name) {
        if (name == null || name.isEmpty()) {
            this.name = "user";
        }
        this.name = name;
    }
}

