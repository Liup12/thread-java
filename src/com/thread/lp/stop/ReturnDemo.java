package com.thread.lp.stop;

public class ReturnDemo extends Thread{
    @Override
    public void run() {
        while (1 == 1){
            if (this.isInterrupted()){
                System.out.println("线程停止了！！！");
                return;
            }
            System.out.println("time = " + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReturnDemo returnDemo = new ReturnDemo();
        returnDemo.start();
        Thread.sleep(2000);
        returnDemo.interrupt();
    }
}
