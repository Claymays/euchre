package com.mays.euchre.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Suit {
    LOW     ("low"),
    HIGH    ("high"),
    CLUBS   ("clubs"),
    SPADES  ("spades"),
    HEARTS  ("hearts"),
    DIAMONDS("diamonds");

    private final String value;
}
