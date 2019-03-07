package com.y.task;


import com.github.pagehelper.Page;
import com.y.bean.User;
import com.y.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 一个简单的任务接口实现类
 */
public class YTaskService implements TaskY {

    private UserService userService;

    @Override
    public int execute() {
        Page<User> allUser = userService.getAllUser(1, 100);
        System.out.println("此为模拟该任务的处理过程--------"+allUser.getTotal());
        return 0;
    }

    public YTaskService(UserService userService){
        this.userService = userService;
    }


    @Override
    public String getTaskId() {
        return null;
    }

}
