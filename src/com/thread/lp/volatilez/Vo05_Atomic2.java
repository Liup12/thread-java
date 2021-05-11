package com.thread.lp.volatilez;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 原子类也并不完全安全，原子类的方法之间是安全的，但是方法与方法之间不一定安全
 */
public class Vo05_Atomic2 implements Runnable {
    private AtomicLong atomicLong = new AtomicLong();

    public synchronized void addNum(){
        System.out.println(Thread.currentThread().getName()+"加了100后的值是："+ atomicLong.addAndGet(100));
        atomicLong.addAndGet(1);
    }


    @Override
    public void run() {
        addNum();
    }

    public static void main(String[] args) throws InterruptedException {
        Vo05_Atomic2 vo05_atomic = new Vo05_Atomic2();
        for (int i = 0; i < 5; i++) {
            new Thread(vo05_atomic).start();
        }

        Thread.sleep(2000);
        System.out.println(vo05_atomic.atomicLong);
    }
}
