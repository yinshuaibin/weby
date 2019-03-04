package com.y.task.TaskController;

import com.y.task.YTaskEngine;
import com.y.task.YTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YTaskController {


    /**
     * 采用注入的方式
     */
    @Autowired
    private YTaskService taskY;

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
        YTaskEngine.addTask(taskY);
    }

}
