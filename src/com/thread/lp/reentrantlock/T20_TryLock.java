package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 17:19
 */
public class T20_TryLock {
    private ReentrantLock lock = new ReentrantLock();

    public void serviceMethod(){
        if (lock.tryLock()){
            System.out.println(Thread.currentThread().getName() + "获取到了锁");
        }else {
            System.out.println(Thread.currentThread().getName() + "没有获取到锁");
        }
        //如果当前线程持有该锁，释放锁
        if (lock.isHeldByCurrentThread()){
            System.out.println(Thread.currentThread().getName() + "释放锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T20_TryLock service = new T20_TryLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod();

            }
        };

        new Thread(runnable).start();
        Thread.sleep(1000);
        new Thread(runnable).start();
    }
}
