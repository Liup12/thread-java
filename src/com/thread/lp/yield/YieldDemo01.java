package com.thread.lp.yield;

/**
 * yield()方法，让当前线程放弃cpu时间片，但放弃的时间不确定，有可能刚刚放弃，马上又抢到了CPU时间片
 */
public class YieldDemo01 extends Thread {

    @Override
    public void run() {
        long begin = System.currentTimeMillis();

        int count = 0;

        for (int i = 0; i < 500000; i++) {
            //Thread.yield();
            count += i;
        }

        long end = System.currentTimeMillis();

        System.out.println("用时：" + (end - begin) + "毫秒");
    }

    public static void main(String[] args) {
        YieldDemo01 demo01 = new YieldDemo01();
        demo01.start();
    }
}
