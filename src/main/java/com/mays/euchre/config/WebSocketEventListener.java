package com.mays.euchre.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    @EventListener
    public void  handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        log.info("User disconnected");
    }
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        log.info("Connection event {}", event.getSource());
    }
}
