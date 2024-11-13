package com.mays.euchre.controllers;

import com.mays.euchre.services.PlayerService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/player")
public class PlayerController {
    private PlayerService service;
}
