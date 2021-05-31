package com.thread.lp.reentrantlock;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/31 15:37
 */
public class T24_AwaitUntil {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    public void waitMethod(){
        try {
            lock.lock();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND,2);
            System.out.println(Thread.currentThread().getName() + "进入wait" + System.currentTimeMillis());
            condition.await();
            System.out.println(Thread.currentThread().getName() + "结束wait" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod(){
        try {
            lock.lock();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND,2);
            System.out.println(Thread.currentThread().getName() + "进入notify" + System.currentTimeMillis());
            condition.signalAll();
            System.out.println(Thread.currentThread().getName() + "结束notify" + System.currentTimeMillis());
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        T24_AwaitUntil service = new T24_AwaitUntil();
        Thread thread = new Thread(() -> {
            service.waitMethod();
        });

        Thread thread2 = new Thread(() -> {
            service.waitMethod();
        });

        thread.start();
        thread2.start();

        Thread.sleep(2000);

        service.notifyMethod();
    }
}
