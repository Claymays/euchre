package com.mays.euchre.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class ViewController {
    @GetMapping("new")
    public String index() {
        return "newGame";
    }

    @GetMapping("board")
    public String board() {
        return "board";
    }
}
