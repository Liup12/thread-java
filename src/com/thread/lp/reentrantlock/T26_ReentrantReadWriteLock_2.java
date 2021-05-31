package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个写锁之间互斥
 * @author liupei
 * @version 1.0
 * @date 2021/5/31 16:12
 */
public class T26_ReentrantReadWriteLock_2 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void write(){
          try {
              lock.writeLock().lock();
              System.out.println(Thread.currentThread().getName() + "  获取写锁，时间：" + System.currentTimeMillis());
              Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
              lock.writeLock().unlock();
          }
    }

    public static void main(String[] args) {
        T26_ReentrantReadWriteLock_2 service = new T26_ReentrantReadWriteLock_2();
        new Thread(()-> service.write()).start();
        new Thread(()-> service.write()).start();
        new Thread(()-> service.write()).start();
        new Thread(()-> service.write()).start();
        new Thread(()-> service.write()).start();
        new Thread(()-> service.write()).start();
        new Thread(()-> service.write()).start();
    }

}
