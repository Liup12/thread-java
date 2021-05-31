package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/31 15:24
 */
public class T22_AwaitUninterruptibly {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public void testMethod(){
        try {
            lock.lock();
            System.out.println("wait begin");
            condition.await();
            System.out.println("wait end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        T22_AwaitUninterruptibly service = new T22_AwaitUninterruptibly();
        Thread thread = new Thread(() -> {
            service.testMethod();
        });

        thread.start();

        Thread.sleep(3000);

        thread.interrupt();
    }
}
