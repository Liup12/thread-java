package com.thread.lp.sync2.synchalf;

public class ThreadB extends Thread{
    TaskService taskService = new TaskService();

    public ThreadB(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void run() {
        taskService.doWork();
    }
}
