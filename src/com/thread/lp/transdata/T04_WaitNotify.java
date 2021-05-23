package com.thread.lp.transdata;

import java.util.ArrayList;
import java.util.List;

/**
 * wait释放锁
 */
public class T04_WaitNotify {



    static class ThreadA extends Thread{

        private Object list;

        public ThreadA(Object list) {
            this.list = list;
        }

        @Override
        public void run() {
            try {
                synchronized (list){
                    System.out.println(Thread.currentThread().getName() + " 进入wait()");
                    list.wait();
                    System.out.println(Thread.currentThread().getName() + " 退出wait()");
                }
            }catch (InterruptedException e){

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
                    System.out.println(Thread.currentThread().getName() + " 进入wait()");
                    list.wait();
                    System.out.println(Thread.currentThread().getName() + " 退出wait()");
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
