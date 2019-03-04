package com.y.task;

import com.github.pagehelper.Page;
import com.y.bean.User;
import com.y.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 通过接口的实现, springboot的CommandLineRunner接口,阻塞队列,实现了简单的无限循环业务处理(简单的任务机制)
 *
 */
@Component
public class YTaskEngine implements CommandLineRunner {
    private static final BlockingDeque<TaskY> tasks = new LinkedBlockingDeque();

    @Autowired
    private UserService userService;

    public static void addTask(TaskY task){
        tasks.offer(task);
    }

    @Override
    public void run(String... args) throws Exception {
        int nThread = 5;
        ExecutorService exec = Executors.newFixedThreadPool(nThread);
        for(int a=0; a<nThread; a++){
            exec.execute(new YTaskWorker());
        }
    }

    private class YTaskWorker implements Runnable{

        @Override
        public void run() {
            while (true){
                TaskY task = null;
                try {
                    task = tasks.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.execute();
                Page<User> allUser = userService.getAllUser(1, 100);
                System.out.println("该条语句仅为数据库查询操作,无意义"+allUser.getTotal()+"------------");
            }
        }
    }
}
