package com.y.config.webSocket.utils;

import com.y.config.webSocket.bean.WebSocketMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

@Slf4j
@Component
@Profile("!test")
public class Consumer implements CommandLineRunner {

    private static final BlockingDeque<WebSocketMessage> linkedBlockingDeque = new LinkedBlockingDeque(16);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    public static void addMessage(WebSocketMessage webSocketMessage){
        try {
            linkedBlockingDeque.put(webSocketMessage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 推送消息
     * @param message
     */
    public void broker(WebSocketMessage message) {
        // 判断 userId 不为空则是订阅, 否则广播
        if (StringUtils.isEmpty(message.getUserId())) {
            simpMessagingTemplate.convertAndSend(message.getDestination(), message.getData());
        } else {
            simpMessagingTemplate.convertAndSendToUser(message.getUserId(), message.getDestination(), message.getData());
        }
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("------------------------ 开启websocket数据读取 --------------------------------------------------");
        ExecutorService exec = Executors.newFixedThreadPool(3);
        long l = System.currentTimeMillis();
        for(int a=0; a<3; a++){
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            WebSocketMessage webSocketMessage = linkedBlockingDeque.take();
                            if (webSocketMessage != null) {
                                broker(webSocketMessage);
                                log.debug(webSocketMessage.toString());
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
