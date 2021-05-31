package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个读锁之间不互斥
 * @author liupei
 * @version 1.0
 * @date 2021/5/31 16:12
 */
public class T26_ReentrantReadWriteLock_1 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read(){
          try {
              lock.readLock().lock();
              System.out.println(Thread.currentThread().getName() + "  获取读锁，时间：" + System.currentTimeMillis());
              Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
              lock.readLock().unlock();
          }
    }

    public static void main(String[] args) {
        T26_ReentrantReadWriteLock_1 service = new T26_ReentrantReadWriteLock_1();
        new Thread(()-> service.read()).start();
        new Thread(()-> service.read()).start();
        new Thread(()-> service.read()).start();
        new Thread(()-> service.read()).start();
        new Thread(()-> service.read()).start();
        new Thread(()-> service.read()).start();
        new Thread(()-> service.read()).start();
    }

}
