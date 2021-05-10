package com.thread.lp.sync2.synchalf;

/**
 * 一半同步，一半异步
 */
public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        ThreadA threadA = new ThreadA(taskService);
        ThreadB threadB = new ThreadB(taskService);
        threadA.setName("AAA");
        threadB.setName("BBB");
        threadA.start();
        threadB.start();
    }
}
