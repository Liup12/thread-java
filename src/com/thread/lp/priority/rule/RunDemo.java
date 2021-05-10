package com.thread.lp.priority.rule;

/**
 * 规律性：线程优先级高的大部分先执行完，CPU尽量将资源让给优先级高的线程
 */
public class RunDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThreadRule1 thread = new MyThreadRule1();
            thread.setPriority(10);
            thread.start();
            MyThreadRule2 thread2 = new MyThreadRule2();
            thread2.setPriority(1);
            thread2.start();
        }

    }
}
