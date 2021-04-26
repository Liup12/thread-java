package com.thread.lp.stop;

/**
 * sleep会使当前线程挂起，在此期间，thread处于中断状态，固isInterrupted方法返回true，且thread线程处于运行状态
 */
public class IsInterrupted_Demo extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 30000; i++) {
            System.out.println("i = " + i);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        try {
            IsInterrupted_Demo thread =  new IsInterrupted_Demo();
            thread.setName("IsInterrupted_Demo");
            thread.start();
            Thread.sleep(10);  //此行代码含义：让当前线程sleep 10毫秒，thread线程运行10毫秒后被中断
            thread.interrupt();
            System.out.println(thread.getName()+"线程是否中断?   " + thread.isInterrupted());
            System.out.println(thread.getName()+"线程是否存活?   " + thread.isAlive());
            System.out.println(thread.getName()+"线程是否中断?   " + thread.isInterrupted());
            System.out.println(thread.getName()+"线程是否存活?   " + thread.isAlive());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
