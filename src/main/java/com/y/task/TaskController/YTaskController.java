package com.y.task.TaskController;

import com.y.config.webSocket.bean.WebSocketMessage;
import com.y.config.webSocket.utils.Consumer;
import com.y.service.UserService;
import com.y.task.YTaskEngine;
import com.y.task.YTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
        message.setData("ceshi");
        Consumer.addMessage(message);
    }

}
