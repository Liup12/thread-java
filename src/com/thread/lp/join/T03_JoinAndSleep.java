package com.thread.lp.join;

/**
 * join(long)与sleep(long)的区别
 * sleep不释放锁
 * join内部使用wait方法，释放锁
 */
public class T03_JoinAndSleep {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);

        Thread thread = threads[0];
        System.out.println("当前线程停止时间："+System.currentTimeMillis());
        //Thread.sleep(2000);
        thread.join(2000);
        System.out.println("当前线程停止结束时间" + System.currentTimeMillis());
    }
}
