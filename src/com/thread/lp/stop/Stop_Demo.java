package com.thread.lp.stop;

public class Stop_Demo extends Thread{
    @Override
    public void run() {
        try {
            this.stop();
            for (int i = 0; i < 50000; i++) {
                System.out.println("i = " + i);
                //Thread.sleep(1000);
            }
        } catch (ThreadDeath e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Stop_Demo demo = new Stop_Demo();
        demo.start();
        Thread.sleep(8000);

    }
}

