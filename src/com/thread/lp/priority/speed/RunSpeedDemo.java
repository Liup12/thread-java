package com.thread.lp.priority.speed;

/**
 * 线程优先级大的线程总是优先运行完Run方法
 */
public class RunSpeedDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.setPriority(Thread.NORM_PRIORITY - 3);
        threadA.start();


        ThreadB threadB = new ThreadB();
        threadB.setPriority(Thread.NORM_PRIORITY + 3);
        threadB.start();

        Thread.sleep(2000);
        threadA.interrupt();
        threadB.interrupt();
        System.out.println("ThreadA count = " + threadA.count);
        System.out.println("ThreadB count = " + threadB.count);
    }
}
