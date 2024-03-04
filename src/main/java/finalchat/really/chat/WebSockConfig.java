package finalchat.really.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 메시지를 구독하는 요청 url - > 메시지 받을 때
        config.enableSimpleBroker("/sub");// 브로커가 구독자들에게
        // 메시지를 발행하는 요청 url -> 메시지를 보낼 때
        config.setApplicationDestinationPrefixes("/pub");  // 구독자 -> 서버로
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp").setAllowedOrigins("*") //여기로 웹소켓 생성
                .withSockJS();
    }
}