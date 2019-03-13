package com.y.config.webSocket.interceptor;

import com.y.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class ConnectedChannelInterceptor extends ChannelInterceptorAdapter {
    /**
     * 在信息发送到channel之前触发
     * @param message
     * @param channel
     * @return
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        StompCommand stompCommand = accessor.getCommand();
        if (stompCommand == null) {
            return null;
        }
        //这里的map对应HandshakeInterceptor拦截器的attributes
        Map<String,Object> map = accessor.getSessionAttributes();
        String username = ((User)map.get("user")).getUsername();
        // String accountId = accessor.getSessionAttributes().get(Constants.SKEY_ACCOUNT_ID).toString();
        // 判断客户端的连接状态
        switch (accessor.getCommand()) {
            case CONNECT:
                log.info("{}发送连接请求................",username);
                // connect(username);
                break;
            case CONNECTED:
                log.info("{}连接成功...................",username);
                break;
            case DISCONNECT:
                log.info("{}断开连接....................",username);
                //disconnect(sessionId, accountId, accessor);
                break;
            case SUBSCRIBE:
                log.info("用户{},订阅了{}",username,accessor.getDestination());
                break;
            default:
                break;
        }
        return message;
    }

    /**
     * 在信息发送到channel后立即触发
     * @param message
     * @param channel
     * @param sent
     */
    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {

    }

    /**
     * 在发送信息结束后触发
     * @param message
     * @param channel
     * @param sent
     * @param ex
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        super.afterSendCompletion(message, channel, sent, ex);
    }

    @Override
    public boolean preReceive(MessageChannel channel) {
        return super.preReceive(channel);
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        return super.postReceive(message, channel);
    }

    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
        super.afterReceiveCompletion(message, channel, ex);
    }

}
