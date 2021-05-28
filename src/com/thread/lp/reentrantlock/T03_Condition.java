package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 若当前锁未被持有，无法等待，否则抛出IllegalMonitorStateException异常
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 13:23
 */
public class T03_Condition {

    static class Service{
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        public void runService(){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
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

    public static void main(String[] args) {
        new ThreadA(new Service()).start();
    }
}
