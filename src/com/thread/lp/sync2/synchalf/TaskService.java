package com.thread.lp.sync2.synchalf;

public class TaskService {

    public void doWork(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("Current Thread name is: " + Thread.currentThread().getName() + "   i = " + i);
        }

        synchronized (this){
            for (int i = 0; i < 1000; i++) {
                System.out.println("【synchronized】   Current Thread name is: " + Thread.currentThread().getName() + "   i = " + i);
            }
        }
    }
}
