package com.thread.lp.transdata;

/**
 * wait释放锁
 */
public class T05_WaitNotify {

    public void testMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + " 进入wait()");
                lock.wait();
                System.out.println(Thread.currentThread().getName() + " 退出wait()");
            }
        }catch (InterruptedException e){

        }
    }

    public void notifyMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + " 进入notify()");
                lock.notify();
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " 退出notify()");
            }
        }catch (InterruptedException e){

        }
    }




    static class ThreadA extends Thread{

        private Object lock;

        public ThreadA(Object list) {
            this.lock = list;
        }

        @Override
        public void run() {
            T05_WaitNotify service = new T05_WaitNotify();
            service.testMethod(lock);
        }
    }


    static class ThreadB extends Thread{

        private Object lock;

        public ThreadB(Object list) {
            this.lock = list;
        }

        @Override
        public void run() {
            T05_WaitNotify service = new T05_WaitNotify();
            service.notifyMethod(lock);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();

        new ThreadA(o).start();
        Thread.sleep(100);
        new ThreadB(o).start();
    }
}
