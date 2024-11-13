package com.mays.euchre.services;

import com.mays.euchre.data.Card;
import com.mays.euchre.data.Player;
import com.mays.euchre.data.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final StateService stateService;
}
