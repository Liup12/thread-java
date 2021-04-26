package com.thread.lp.stop;

/**
 * 如何让main线程中断？
 * interrupted是Thread类静态方法，用于判断当前线程是否被中断，返回boolean类型结果，当该线程为中断状态时，调用此方法将会清除该中断状态，
 * 换句话说：该方法会将已中断的线程恢复运行状态
 */
public class Interrupted_Demo {

    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        Thread.currentThread().interrupt();

        System.out.println(Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
    }
}
