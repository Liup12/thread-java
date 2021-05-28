package com.thread.lp.threadlocal;

import java.util.HashMap;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 11:17
 */
public class T02_ThreadLocal {

    private static ThreadLocal l = new ThreadLocal();

    static class ThreadA extends Thread{
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    l.set("ThreadA = " + i);
                    System.out.println("ThreadA get value = " + l.get());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    l.set("ThreadB = " + i);
                    System.out.println("ThreadB get value = " + l.get());
                    Thread.sleep(200);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        try {
            for (int i = 0; i < 100; i++) {
                l.set("main = " + i);
                System.out.println("main get value = " + l.get());
                Thread.sleep(200);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
