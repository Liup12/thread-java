package com.thread.lp.priority;

/**
 * 该用例主要测试线程优先级的基础性，默认优先级为5，最大优先级为10，最小优先级1
 *
 */
public class PriorityExtendDemo{

    /**
     * The minimum priority that a thread can have.
     */
    public final static int MIN_PRIORITY = 1;

    /**
     * The default priority that is assigned to a thread.
     */
    public final static int NORM_PRIORITY = 5;

    /**
     * The maximum priority that a thread can have.
     */
    public final static int MAX_PRIORITY = 10;


    public static void main(String[] args) {
        System.out.println("main thread begin priority = "  +  Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority = "  +  Thread.currentThread().getPriority());

        MyThread1 myThread1 = new MyThread1();  //继承自main线程优先级
        myThread1.start();
    }



}
