package com.y.config.webSocket.config;

import com.y.config.webSocket.interceptor.ConnectedChannelInterceptor;
import com.y.config.webSocket.interceptor.WebSocketInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private WebSocketInterceptor webSocketInterceptor;

    @Autowired
    private ConnectedChannelInterceptor connectedChannelInterceptor;

    /**
     * 端点的作用——>客户端在订阅或发布消息到目的地址前，要连接该端点。
     * <p>
     * 将url路径注册为STOMP端点，这个路径与发送和接收消息的目的路径有所不同，
     * 这是一个端点，客户端在订阅或发布消息到目的地址前，要连接该端点,即用户发送请求url="/stomp"与STOMP server进行连接。
     * 之后再转发到订阅路径;
     * </p>
     *
     * @param stompEndpointRegistry stomp 服务端点注册实例
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //在网页上可以通过"/stomp"来和服务器的WebSocket连接, 和客户端创建连接时的url有关，
        // 其中setAllowedOrigins()方法表示允许连接的域名，withSockJS()方法表示支持以SockJS方式连接服务器。
        stompEndpointRegistry.addEndpoint("/stomp")
                             .addInterceptors(webSocketInterceptor)
                             .setAllowedOrigins("*")
                             .withSockJS();
    }

    /**
     * 配置了一个简单的消息代理，如果不重载，默认情况下回自动配置一个简单的内存消息代理，
     * 用来处理以"/topic"为前缀的消息。这里重载configureMessageBroker()方法，
     * 消息代理将会处理前缀为"/topic"和"/queue"的消息。
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //应用程序以/app为前缀，代理目的地以/topic、/user为前缀
        registry.enableSimpleBroker("/topic", "/toUser"); // 这句话表示在topic和weby这两个域上可以向客户端发消息
        registry.setApplicationDestinationPrefixes("/weby"); //表示客户单向服务器端发送时的主题上面需要加 /weby 作为前缀
        registry.setUserDestinationPrefix("/toUser"); // 表示给指定用户一对一的主题前缀是/toUser
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(connectedChannelInterceptor);
    }




























}
