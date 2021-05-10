package com.thread.lp.priority.rule;

public class MyThreadRule1 extends Thread{

    @Override
    public void run() {
        long begin = System.currentTimeMillis();

        int count = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                count += i;
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("thread1 用时：" + (end - begin) + "毫秒");
    }
}
