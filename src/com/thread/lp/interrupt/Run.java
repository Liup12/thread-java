package com.thread.lp.interrupt;

public class Run {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();
        //Thread.sleep(3000);

        System.out.println("线程是否已经终止1？ " + myThread.isInterrupted());
        System.out.println("线程是否已经终止2？ " + myThread.isInterrupted());
        System.out.println("线程是否已经终止1？ " + MyThread.interrupted());
        System.out.println("线程是否已经终止2？ " + MyThread.interrupted());
        System.out.println("线程是否活跃？ " + myThread.isAlive());


    }
}
