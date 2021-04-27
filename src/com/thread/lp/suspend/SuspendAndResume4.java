package com.thread.lp.suspend;

/**
 * 不理解
 * 当thread调用System.out（PrintStream）对象的printIn()方法的时候，获取了PrintStream对象锁，thread线程被suspend()方法暂停了，但未释放PrintStream对象锁，导致main线程无法获取PrintStream对象锁，
 * 所以main方法始终不会打印 "main end"
 */
public class SuspendAndResume4 extends Thread{
    private long i = 0;
    @Override
    public void run() {
        while (true){
            i++;
            System.out.println("i = " + i);
        }
    }
    /*public void println(String x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }*/
    public static void main(String[] args) throws InterruptedException {
        SuspendAndResume4 thread = new SuspendAndResume4();

        thread.start();
        Thread.sleep(20);
        thread.suspend();

        System.out.println("main end!");
    }
}
