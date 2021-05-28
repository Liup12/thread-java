package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock不释放锁
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 13:06
 */
public class T02_ReentrantLock {

    static class Service{
        private Lock lock = new ReentrantLock();
        public void runServiceA(){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " runServiceA  begin " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " runServiceA end" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void runServiceB(){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " runServiceB  begin " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " runServiceB  end" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadA extends Thread {
        private Service service;

        public ThreadA(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.runServiceA();
        }
    }

    static class ThreadB extends Thread {
        private Service service;

        public ThreadB(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.runServiceB();
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        new ThreadA(service).start();
        new ThreadA(service).start();
        new ThreadB(service).start();
        new ThreadB(service).start();
    }
}
