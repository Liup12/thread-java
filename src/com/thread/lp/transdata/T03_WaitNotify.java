package com.thread.lp.transdata;

import java.util.ArrayList;
import java.util.List;

/**
 * 当notify()唤醒了需要持有lock锁的线程，而没有线程因为需要这个lock锁而处于阻塞状态。该命令将会被忽略。
 */
public class T03_WaitNotify {
    private static List list = new ArrayList();

    public static void add(String name){
        list.add(name);
    }

    public static int size(){
        return list.size();
    }


    static class ThreadA extends Thread{

        private Object list;

        public ThreadA(Object list) {
            this.list = list;
        }

        @Override
        public void run() {

            synchronized (list){
                for (int i = 0; i < 10; i++) {
                    T03_WaitNotify.add("1");
                    if (T03_WaitNotify.size() == 5){
                        list.notify();
                        System.out.println("已经发出了唤醒通知");
                    }
                    System.out.println("当前集合的size = " + T03_WaitNotify.size());
                }
            }
        }
    }


    static class ThreadB extends Thread{

        private Object list;

        public ThreadB(Object list) {
            this.list = list;
        }

        @Override
        public void run() {
            try {
                synchronized (list){
                    System.out.println("wait begin   ");
                    list.wait();
                    System.out.println("wait end time " + System.currentTimeMillis());
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Object o = new Object();
        new ThreadB(o).start();
        new ThreadA(o).start();
    }
}
