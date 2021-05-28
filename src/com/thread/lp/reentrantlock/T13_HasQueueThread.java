package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock.hasQueuedThread(thread2)   thread2线程是否在等待lock锁
 * lock.hasQueuedThreads()  是否有线程等待lock锁
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 15:34
 */
public class T13_HasQueueThread {
    private ReentrantLock lock = new ReentrantLock();

    public void serviceMethod(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "sleep start");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T13_HasQueueThread service = new T13_HasQueueThread();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod();
            }
        };


        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        Thread.sleep(600);
        thread2.start();
        Thread.sleep(600);
        System.out.println(service.lock.hasQueuedThread(thread1));
        System.out.println(service.lock.hasQueuedThread(thread2));
        System.out.println(service.lock.hasQueuedThreads());

        Thread.sleep(6000);
        System.out.println(service.lock.hasQueuedThreads());

    }
}
