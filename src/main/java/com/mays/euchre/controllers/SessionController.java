package com.mays.euchre.controllers;

import com.mays.euchre.data.Session;
import com.mays.euchre.data.Player;
import com.mays.euchre.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.ArrayList;
import java.util.List;

@Controller("/app")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService               sessionService;
    private final SimpMessageSendingOperations messagingTemplate;
    private       SpringTemplateEngine         templateEngine;
//    List<Connection> connections = new ArrayList<Connection>();

    @MessageMapping("/check")
    @SendTo("/game/status")
    public Session join() {
        var session = sessionService.newGame();
        var context = new Context();
//        context.setVariable("session", session);
//        var rendered = templateEngine.process("fragments/board", context);
//        messagingTemplate.convertAndSend("/new", rendered);
        return session;
    }

    @PostMapping("/start")
    public Session startGame(@RequestBody List<Player> players) {
        return sessionService.start(players);
    }
}
