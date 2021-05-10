package com.thread.lp.priority.speed;

public class ThreadB extends Thread{

    long count = 0;
    @Override
    public void run() {
        try {
            while (true){
                if (this.isInterrupted()){
                    throw new InterruptedException();
                }
                count++;
            }
        }catch (InterruptedException e){
            System.out.println("ThreadB 线程退出了。。。。");
        }
    }
}
