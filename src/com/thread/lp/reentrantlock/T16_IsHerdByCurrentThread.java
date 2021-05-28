package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock.isHeldByCurrentThread() 判断lock锁是否被当前线程持有
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 16:10
 */
public class T16_IsHerdByCurrentThread {
    private static ReentrantLock lock;
    public static void main(String[] args) {
        lock = new ReentrantLock();
        Thread thread = new Thread(() -> {
            lock.lock();
            try {
                System.out.println(lock.isHeldByCurrentThread());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println(lock.isHeldByCurrentThread());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });
        thread.start();
        thread2.start();
        System.out.println(lock.isHeldByCurrentThread());
    }
}
