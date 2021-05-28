package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock.getWaitQueueLength(condition)
 * 获取执行了condition.await()方法进入并等待signal(）的线程数量
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 15:03
 */
public class T12_GetWaitQueueLength {
    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();
    public void serviceMethod(){
        lock.lock();
        try {
            System.out.println("当前有"+ lock.getWaitQueueLength(condition) + "个线程等待Condition唤醒");
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal(){
        lock.lock();
        try {
            System.out.println("当前有"+ lock.getWaitQueueLength(condition) + "个线程等待Condition唤醒");
            condition.signalAll();
            System.out.println("当前有"+ lock.getWaitQueueLength(condition) + "个线程等待Condition唤醒");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T12_GetWaitQueueLength service = new T12_GetWaitQueueLength();
        Runnable runnable = new Runnable() {
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
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        Thread.sleep(2000);
        service.signal();
    }

}
