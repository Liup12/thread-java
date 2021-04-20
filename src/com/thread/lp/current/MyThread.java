package com.thread.lp.current;

/**
 * @author Administrator
 */
public class MyThread extends Thread{
    public MyThread() {
        System.out.println("Constructor created..... --->" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("Run()..... --->" + Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //myThread.start();
        myThread.run();
    }
}
