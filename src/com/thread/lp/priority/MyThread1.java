package com.thread.lp.priority;

public class MyThread1  extends Thread{
    @Override
    public void run() {
        System.out.println("Thread1 run priority =" + this.getPriority());
        this.setPriority(7);
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }

}
