package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock.isLocked() 判断当前锁是否被任意线程持有
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 16:17
 */
public class T17_IsLocked {


    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "isLocked = " + lock.isLocked());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() +"释放锁之后？ "+lock.isLocked());
            }
        }).start();

        Thread.sleep(222);
        System.out.println(Thread.currentThread().getName() + " isLocked = " + lock.isLocked());


        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " isLocked = " + lock.isLocked());
        }).start();
    }
}
