package com.mays.euchre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

import java.util.HashMap;

@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/new");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws");
        registry.addEndpoint("/new");
    }

//    @Bean
//    public HandlerMapping handlerMapping() {
//        var map = new HashMap<String, WebSocketHandler>();
//        map.put("/session", new SessionHandler());
//        int order = -1;
//
//        return new SimpleUrlHandlerMapping(map, order);
//    }

//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(sessionHandler(), "/session");
//    }

//    @Bean
//    public WebSocketHandler sessionHandler() {
//        return new SessionHandler();
//    }
}
