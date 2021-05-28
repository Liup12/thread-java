package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  使用Condition可对线程进行分组唤醒
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 13:23
 */
public class T06_Condition {

    static class Service{
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private Condition condition2 = lock.newCondition();

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
                condition2.await();
                System.out.println(Thread.currentThread().getName() + "Await结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        public void signalCondition(){
            lock.lock();
            try {
                condition.signal();
                System.out.println("signal condition");
            } finally {
                lock.unlock();
            }
        }
        public void signalCondition2(){
            lock.lock();
            try {
                condition2.signal();
                System.out.println("signal condition2");
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
        new ThreadA(service).start();
        new ThreadB(service).start();
        Thread.sleep(2000);
        service.signalCondition();
        Thread.sleep(2000);
        service.signalCondition2();
    }
}
