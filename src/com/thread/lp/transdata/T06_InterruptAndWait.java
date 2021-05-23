package com.thread.lp.transdata;

/**
 * 当Interrupt方法遇到了Wait方法
 */
public class T06_InterruptAndWait {

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

    public static class ThreadA extends Thread{
        private Object lock;

        public ThreadA(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            T06_InterruptAndWait service = new T06_InterruptAndWait();
            service.testMethod(lock);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        ThreadA threadA = new ThreadA(0);
        threadA.start();
        Thread.sleep(200);
        threadA.interrupt();

    }
}
