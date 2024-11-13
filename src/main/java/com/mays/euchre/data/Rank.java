package com.mays.euchre.data;

import lombok.Getter;

@Getter
public enum Rank {
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

}

