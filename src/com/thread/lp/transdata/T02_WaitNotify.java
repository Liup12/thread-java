package com.thread.lp.transdata;

/**
 * 1、调用wait()或者notify()方法的对象锁，必须是被持有状态，否则将会抛出IllegalMonitorStateException异常
 */
public class T02_WaitNotify {

    static class ThreadA extends Thread{
        private Object object;

        public ThreadA(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            try {

                    System.out.println("begin  wait 第一行");
                    object.wait();
                    System.out.println("end  wait 第二行");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class ThreadB extends Thread{
        private Object object;

        public ThreadB(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            synchronized (object){
                System.out.println("begin notify 第一行");
                object.notify();
                System.out.println("end notify 第二行");
            }
        }
    }

    public static void main(String[] args) {
        Object o = new Object();
        new ThreadA(o).start();
        new ThreadB(o).start();

    }

}
