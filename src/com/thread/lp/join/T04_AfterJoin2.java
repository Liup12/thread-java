package com.thread.lp.join;

/**
 * ???????
 */
public class T04_AfterJoin2 {


    static class ThreadA extends Thread{
        private ThreadB threadB;

        public ThreadA(ThreadB threadB) {
            this.threadB = threadB;
        }

        @Override
        public void run() {
            try {
                synchronized (threadB){
                    System.out.println(" A run begin time =" + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println(" A run end time =" + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        synchronized public void run() {
            try {
                System.out.println(" B run begin time =" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(" B run end time =" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        ThreadB threadB = new ThreadB();
        ThreadA threadA = new ThreadA(threadB);

        threadA.start();
        threadB.start();

        System.out.println("main end");

    }
}
