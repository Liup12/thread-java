package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock.getHoldCount() 获取当前持有lock锁的线程数
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 14:38
 */
public class T10_GetHoldCount {

    private ReentrantLock lock = new ReentrantLock();

    public void serviceMethod1(){
        lock.lock();
        try {
            System.out.println("Current LockNumber " + lock.getHoldCount());
            serviceMethod2();
        }finally {
            lock.unlock();
            System.out.println("serviceMethod1 unlock Current LockNumber " + lock.getHoldCount());
        }
    }

    public void serviceMethod2(){
        lock.lock();
        try {
            System.out.println("Current LockNumber " + lock.getHoldCount());
        }finally {
            lock.unlock();
            System.out.println("serviceMethod2  unlock Current LockNumber " + lock.getHoldCount());
        }
    }

    public static void main(String[] args) {
        T10_GetHoldCount service = new T10_GetHoldCount();
        new Thread(()->{
            service.serviceMethod1();
        }).start();
    }
}
