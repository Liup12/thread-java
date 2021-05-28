package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 13:06
 */
public class T01_ReentrantLock {

    static class Service{
        private Lock lock = new ReentrantLock();
        public void runService(){
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " run " + i);
                }
            }finally {
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
            service.runService();
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        new ThreadA(service).start();
        new ThreadA(service).start();
        new ThreadA(service).start();
        new ThreadA(service).start();
    }
}
