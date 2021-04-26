package com.thread.lp.stop;

/**
 * 在sleep()状态中停止线程
 *
 * 如果在线程sleep()之间中断该线程，那么该线程将抛出InterruptedException异常，并清除中断状态
 */
public class StopInSleep_Demo extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("run begin");
            Thread.sleep(2000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡状态中被停止,进入run方法catch语句块" + this.isInterrupted());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StopInSleep_Demo thread = new StopInSleep_Demo();
        thread.start();
        Thread.sleep(200);
        thread.interrupt();
    }
}
