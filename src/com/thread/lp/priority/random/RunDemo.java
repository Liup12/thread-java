package com.thread.lp.priority.random;

import com.thread.lp.priority.rule.MyThreadRule1;
import com.thread.lp.priority.rule.MyThreadRule2;

/**
 * 随机性：线程优先级不能代表程序运行的顺序，线程优先级高的线程并不一定每次都优先运行完run()方法中的任务
 */
public class RunDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThreadRule1 thread = new MyThreadRule1();
            thread.setPriority(6);
            thread.start();
            MyThreadRule2 thread2 = new MyThreadRule2();
            thread2.setPriority(5);
            thread2.start();
        }

    }
}
