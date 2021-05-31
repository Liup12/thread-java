package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AwaitUninterruptibly()方法，wait状态线程被interrupt终端不会抛出异常
 * @author liupei
 * @version 1.0
 * @date 2021/5/31 15:24
 */
public class T23_AwaitUninterruptibly_2 {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public void testMethod(){
        try {
            lock.lock();
            System.out.println("wait begin");
            condition.awaitUninterruptibly();
            System.out.println("wait end");
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        T23_AwaitUninterruptibly_2 service = new T23_AwaitUninterruptibly_2();
        Thread thread = new Thread(() -> {
            service.testMethod();
        });

        thread.start();

        Thread.sleep(3000);

        thread.interrupt();
    }
}
