package com.thread.lp.reentrantlock;

import com.thread.lp.interrupt.Run;

import java.util.concurrent.locks.ReentrantLock;

/**
 * getQueueLength() 获取等待获取lock锁的线程数量
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 14:55
 */
public class T11_GetQueueLength {

    private ReentrantLock lock = new ReentrantLock();

    public void serviceMethod(){
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("当前等待此锁的线程数量" + lock.getQueueLength());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        T11_GetQueueLength service = new T11_GetQueueLength();
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
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

}
