package com.y.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 为taskCallBack赋值
 */
@Component
@Slf4j
public class TaskCommonRunner implements YTaskCallBack, CommandLineRunner {

    @Autowired
    private YTaskEngine taskEngine;

    @Override
    public void finshCallBack() {
        log.info("此处可以进行callback操作");
    }

    @Override
    public void run(String... args) throws Exception {
        taskEngine.setyTaskCallBack(this);
    }
}
