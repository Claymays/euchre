package com.mays.euchre.data;

import lombok.Data;

import java.util.List;

@Data
public class Player {
    private int          id;
    private List<Card>   hand;
    private String       name;
}

