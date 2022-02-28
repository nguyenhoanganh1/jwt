package com.chat.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketChatConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocketApp")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // localhost:15672 : is localhost Rabbit
        // abbitmq-plugins enable rabbitmq_stomp
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableStompBrokerRelay("/topic")
               /* .setAutoStartup(true)
                .setSystemLogin("amazonmq-login")
                .setSystemPasscode("amazonmq-pass")
                .setClientLogin("amazonmq-login")
                .setClientPasscode("amazonmq-pass")
                .setTcpClient(client);*/
                .setRelayHost("localhost")
                .setRelayPort(61613)
                .setClientLogin("guest")
                .setClientPasscode("guest");
    }
}
