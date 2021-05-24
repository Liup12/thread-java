package com.thread.lp.join;

/**
 * 线程A加入到线程B，线程B状态变为wait，线程A抢到锁，执行线程A的run方法
 *
 */
public class T01_Join {

    static class ThreadA extends Thread{
        @Override
        public void run() {
            double random = Math.random();
            System.out.println("我想在最前面输出 " + random);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        // threadA.join();
        System.out.println("main 线程结束了");
    }
}
