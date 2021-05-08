package com.thread.lp.sync.reentrant;

public class Main {
    public int i  = 10;

    public synchronized void operateMainMethod(){
        try {
            i--;
            System.out.println("main print i  = " + i);
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
