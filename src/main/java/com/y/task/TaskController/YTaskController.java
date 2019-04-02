package com.y.task.TaskController;

import com.y.config.webSocket.bean.WebSocketMessage;
import com.y.config.webSocket.utils.Consumer;
import com.y.service.UserService;
import com.y.task.YTaskEngine;
import com.y.task.YTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class YTaskController {

    @Autowired
    private UserService userService;

    /**
     * 模拟生成任务task
     */
    @RequestMapping("/addTask")
    public void addTask(){
        synchronized ("1"){
            //此处调用清空taskY所有属性的方法
            //此处重新设置值
        }
        // 添加到阻塞队列中
        YTaskService taskY = new YTaskService(userService);
        YTaskEngine.addTask(taskY);
        WebSocketMessage message = new WebSocketMessage();

        // 下面3行为测试webSocket
        message.setUserId("1");
        message.setDestination("/user");
        message.setData("这是一条点对点消息");
        Consumer.addMessage(message);


        WebSocketMessage message1 = new WebSocketMessage();
        message1.setData("这是一条广播消息");
        message1.setDestination("/topic");
        Consumer.addMessage(message1);
    }

    /**
     * 用来接收消息
     * @param topic
     * @param headers
     */
    @MessageMapping("/stomp")// WebSocketConfig中配置的接收前台消息的前缀
    public void getMessage(@Header("atytopic") String topic, @Headers Map<String, Object> headers){
        System.out.println(topic);
        System.out.println(headers);
        WebSocketMessage message = new WebSocketMessage();
        message.setUserId("1");
        message.setDestination("/user");
        message.setData("我收到了你发的消息");
        Consumer.addMessage(message);
    }
}
