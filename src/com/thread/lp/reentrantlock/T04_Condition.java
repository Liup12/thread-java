package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  await方法释放锁，当线程被signal唤醒，会重新获取锁，然后再在finally语句块中释放该锁
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 13:23
 */
public class T04_Condition {

    static class Service{
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        public void runService(){
            lock.lock();
            try {
                System.out.println("当前线程 "+ Thread.currentThread().getName() + "Await开始");
                condition.await();
                System.out.println("当前线程 "+ Thread.currentThread().getName() + "Await开始");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("当前线程 "+ Thread.currentThread().getName() + "释放锁");
            }
        }

        public void signal(){
            lock.lock();
            try {
                condition.signal();
                System.out.println("当前线程 "+ Thread.currentThread().getName() + "signal");
            } finally {
                lock.unlock();
                System.out.println("当前线程 "+ Thread.currentThread().getName() + "signal 释放锁");
            }
        }
    }


    static class ThreadA extends Thread{
        private Service service;

        public ThreadA(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.runService();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        new ThreadA(service).start();

        Thread.sleep(2000);
        service.signal();
    }
}
