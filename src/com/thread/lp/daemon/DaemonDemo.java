package com.thread.lp.daemon;

/**
 * 守护线程围绕进程中非守护线程，当进程中任然有非守护线程运行，守护线程都不会退出
 */
public class DaemonDemo extends Thread{
    @Override
    public void run() {

        try {
            int count = 1;
            while (true){
                count ++;
                System.out.println(this.getName() + " count =" + count);
            Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DaemonDemo thread = new DaemonDemo();
        thread.setName("Thread-1");
        DaemonDemo thread2 = new DaemonDemo();
        thread2.setName("Thread-2");

        thread.setDaemon(true);
       // thread2.setDaemon(true);
        thread.start();
        thread2.start();
        Thread.sleep(5000);
        System.out.println("main方法结束了, main方法的守护线程thread也要离开了.....");

    }
}
