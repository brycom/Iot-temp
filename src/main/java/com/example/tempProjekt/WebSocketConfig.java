package com.example.tempProjekt;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/connect")
        .setAllowedOriginPatterns("*"); // Ingen SockJS, direkt WebSocket
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    // Definiera var meddelanden skickas
    config.setApplicationDestinationPrefixes("/arduino");
    // Aktivera inbyggd broker för att skicka meddelanden till /latest
    config.enableSimpleBroker("/latest");
  }
}
