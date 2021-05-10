package com.thread.lp.stop;

public class StopInSleep_Demo2 extends Thread{

    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                System.out.println("i = "+ i);
            }
            System.out.println("run begin");
            Thread.sleep(200000); // 2、线程中断标识为true,但遇到了sleep方法,抛出异常  (native方法)
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("先停止,再遇到了sleep,进入run方法catch语句块" + this.isInterrupted());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StopInSleep_Demo2 thread2  = new StopInSleep_Demo2();
        thread2.start();
        thread2.interrupt();//1、 interrupt()方法并不会立刻停止该线程。
        System.out.println("main end");
    }
}
