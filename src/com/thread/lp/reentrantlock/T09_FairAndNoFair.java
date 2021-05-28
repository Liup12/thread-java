package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁：先启动的线程优先获得锁
 * 非公平锁: 先启动的线程未必优先获得锁
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 14:18
 */
public class T09_FairAndNoFair {
    static class Service{
        private ReentrantLock lock;

        public Service(boolean isFair) {
            this.lock = new ReentrantLock(isFair);
        }

        public void serviceMethod(){
            lock.lock();
            try {
                System.out.println("ThreadName = " + Thread.currentThread().getName() + "被锁定");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        Service service = new Service(true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadName = " + Thread.currentThread().getName() + "开始运行");
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
