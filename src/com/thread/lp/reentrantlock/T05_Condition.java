package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 13:23
 */
public class T05_Condition {

    static class Service{
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void serviceA(){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "Await开始");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "Await结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void serviceB(){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "Await开始");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "Await结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void signal(){
            lock.lock();
            try {
                condition.signalAll();
                System.out.println("signal All");
            } finally {
                lock.unlock();
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
            service.serviceA();
        }
    }
    static class ThreadB extends Thread{
        private Service service;

        public ThreadB(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.serviceB();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        new ThreadA(service).start();
        new ThreadB(service).start();
        Thread.sleep(2000);
        service.signal();
    }
}
