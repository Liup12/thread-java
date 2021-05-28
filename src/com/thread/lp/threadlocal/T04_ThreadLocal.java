package com.thread.lp.threadlocal;

import java.util.Date;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 11:17
 */
public class T04_ThreadLocal {

    private static ThreadLocalE l = new ThreadLocalE();



    static class ThreadLocalE extends ThreadLocal{
        @Override
        protected Object initialValue() {
            return System.currentTimeMillis();
        }
    }

    static class ThreadA extends Thread{
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {

                    System.out.println("ThreadA get value = " + l.get());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        try {
            for (int i = 0; i < 100; i++) {

                System.out.println("main get value = " + l.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}