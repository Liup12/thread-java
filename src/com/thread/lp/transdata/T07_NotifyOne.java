package com.thread.lp.transdata;

public class T07_NotifyOne {


    public void testMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("begin wait()");
                lock.wait();
                System.out.println("end wait()");
            }
        }catch (InterruptedException e){
            System.out.println("程序进入异常");
        }
    }

    static class ThreadA extends Thread{
        private Object lock;

        public ThreadA(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            T07_NotifyOne service = new T07_NotifyOne();
            service.testMethod(lock);
        }
    }


    static class ThreadB extends Thread{
        private Object lock;

        public ThreadB(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            T06_InterruptAndWait service = new T06_InterruptAndWait();
            service.testMethod(lock);
        }
    }

    static class ThreadC extends Thread{
        private Object lock;

        public ThreadC(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            T06_InterruptAndWait service = new T06_InterruptAndWait();
            service.testMethod(lock);
        }
    }

    static class NotifyThread extends Thread{
        private Object lock;

        public NotifyThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock){
               lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        ThreadA threadA = new ThreadA(o);
        ThreadB threadB = new ThreadB(o);
        ThreadC threadC = new ThreadC(o);
        threadA.start();
        threadB.start();
        threadC.start();

        Thread.sleep(2000);
        NotifyThread thread = new NotifyThread(o);

        thread.start();
    }
}
