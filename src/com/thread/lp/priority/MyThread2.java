package com.thread.lp.priority;

/**
 * 继承MyThread1优先级
 */
public class MyThread2 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread2 run priority =" + this.getPriority());
    }
}
