package com.thread.lp.stop;

public class Stop_Demo2 extends Thread {
    @Override
    public void run() {
        try {
            this.stop();
        }catch (ThreadDeath e){
            e.printStackTrace();
            System.out.println("进入run()方法 catch语句块");
        }
    }

    public static void main(String[] args) {
        Stop_Demo2 demo2 = new Stop_Demo2();
        demo2.start();

    }
}
