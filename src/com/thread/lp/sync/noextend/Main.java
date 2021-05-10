package com.thread.lp.sync.noextend;

/**
 * 同步方法不具备继承性
 */
public class Main {

    public synchronized void serviceMethod(){
        try {
            System.out.println("main serviceMethod run time = " + System.currentTimeMillis());
            System.out.println("main serviceMethod begin to sleep 5000ms");
            Thread.sleep(5000);
            System.out.println("main serviceMethod sleep end time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
