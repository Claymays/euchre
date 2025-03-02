package com.mays.euchre.controllers;

import com.mays.euchre.services.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
@RequiredArgsConstructor
public class ViewController {
    private final StateService stateService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("board")
    public String board(Model model) {
        var hand = stateService.deal().getActiveOrder().getFirst();
        model.addAttribute("player", hand);
        return "board";
    }
}
