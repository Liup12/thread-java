package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 13:49
 */
public class T08_CustomerAndProvider {

    private static boolean customerFirst = true;

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    static class Customer extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    while (customerFirst == false){
                        System.out.println("有可能连续DDDDD");
                        condition.await();
                    }
                    System.out.println("AAAAA");
                    customerFirst = false;
                    condition.signalAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


    static class Provider extends Thread{
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    while (customerFirst == true){
                        System.out.println("有可能连续CCCCC");
                        condition.await();
                    }
                    System.out.println("BBBBBBB");
                    customerFirst = true;
                    condition.signalAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Provider().start();
        new Provider().start();
        new Customer().start();
        new Customer().start();

    }
}
