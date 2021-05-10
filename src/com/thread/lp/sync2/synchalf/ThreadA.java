package com.thread.lp.sync2.synchalf;

public class ThreadA extends Thread{
    TaskService taskService = new TaskService();

    public ThreadA(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void run() {
        taskService.doWork();
    }
}
