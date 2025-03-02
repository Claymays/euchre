package com.mays.euchre.controllers;

import com.mays.euchre.data.*;
import com.mays.euchre.services.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("/state")
@RequiredArgsConstructor
public class StateController {
    private final StateService stateService;

    @GetMapping("/deal")
    public State deal() {
        return stateService.deal();
    }

    @PostMapping("/play")
    public State play(@RequestParam Card card, @RequestParam Player player) {
        return stateService.playCard(player, card);
    }

//    @PostMapping("/bid")
//    public State bid(@RequestParam Team bidder, @RequestParam Card card) {
//        return stateService.callBid(bidder, card);
//    }
}
