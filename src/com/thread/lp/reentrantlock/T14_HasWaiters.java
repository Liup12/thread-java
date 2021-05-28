package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 15:54
 */
public class T14_HasWaiters {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void serviceMethod(){
        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod(){
        lock.lock();
        try {
            System.out.println("当前有没有线程等待唤醒?"+lock.hasWaiters(condition));
            System.out.println("当前等待唤醒线程数量?"+lock.getWaitQueueLength(condition));
            condition.signalAll();
        }  finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T14_HasWaiters service = new T14_HasWaiters();
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                service.serviceMethod();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        Thread.sleep(4000);
        service.notifyMethod();
    }
}
