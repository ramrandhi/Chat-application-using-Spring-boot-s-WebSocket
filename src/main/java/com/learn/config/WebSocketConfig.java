package com.learn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/chat")         // this is the end point for where this chat application uses
				.setAllowedOriginPatterns("http://localhost:8080")    // telling application to accept the end point coming from this url pattern
				.withSockJS();    //   actually makes accessable for more clients
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// TODO Auto-generated method stub
		registry.enableSimpleBroker("/topic");             // this is for the specific groups where they are subscribed to that particular group
		registry.setApplicationDestinationPrefixes("/app");    // the routes should be coming from this route
	}

}
