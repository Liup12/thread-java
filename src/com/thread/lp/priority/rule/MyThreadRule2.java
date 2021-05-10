package com.thread.lp.priority.rule;

public class MyThreadRule2 extends Thread {
    @Override
    public void run() {
        long begin = System.currentTimeMillis();

        int count = 0;
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 500000; i++) {
                count += i;
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("thread2 用时：" + (end - begin) + "毫秒");
    }
}
