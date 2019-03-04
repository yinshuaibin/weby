package com.y.task;


/**
 * 简单的任务处理机制, 仅一个方法, 实现该接口实现该方法, YTaskEngine中有线程一直监听, 自动执行该方法
 */
public interface TaskY {

    /**
     * 执行的具体逻辑
     * @return
     */
    int execute();

    /**
     * 某个具体执行的过程的id
     * @return
     */
    String getTaskId();
}
