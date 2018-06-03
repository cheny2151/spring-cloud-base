package com.cheney.javaconfig;

import com.cheney.wesocket.WebSocketMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketMessageHandler(), "/ws");
    }

    @Bean
    public WebSocketMessageHandler webSocketMessageHandler() {
        return new WebSocketMessageHandler();
    }

}
