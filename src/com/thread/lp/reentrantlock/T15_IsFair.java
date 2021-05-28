package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * isFair() 判断当前锁是否公平锁
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 16:08
 */
public class T15_IsFair {

    private static ReentrantLock lock;
    public static void main(String[] args) {
        lock = new ReentrantLock(false);
        new Thread(()->{
            lock.lock();
            try {
                System.out.println(lock.isFair());
            }finally {
                lock.unlock();
            }
        }).start();
    }
}
