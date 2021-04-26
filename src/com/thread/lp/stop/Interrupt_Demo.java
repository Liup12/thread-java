package com.thread.lp.stop;

/**
 * 实现Runnable接口，当前类为"待执行的任务"，需要线程去启动这个任务，不能直接start
 * 继承自Thread类，默认继承Thread类中start方法。可直接调用start方法启动该线程
 *
 */
public class Interrupt_Demo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println("i = "+ i);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Interrupt_Demo run1 = new Interrupt_Demo();
        run1.start();
        Thread.sleep(2000);
        run1.interrupt();  //

        System.out.println(run1.getName()+"->"+run1.isInterrupted());
        System.out.println(Thread.currentThread().getName()+"->"+Thread.currentThread().isInterrupted());
    }
}
