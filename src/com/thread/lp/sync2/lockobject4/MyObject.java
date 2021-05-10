package com.thread.lp.sync2.lockobject4;

public class MyObject {

    public  void myObjectMethod(){
        synchronized (this){
            try {
                System.out.println("myObjectMethod _getLockTime = "+ System.currentTimeMillis()+ " run threadName = " + Thread.currentThread().getName());
                System.out.println("===============================");
                Thread.sleep(2000);
                System.out.println("myObjectMethod releaseLockTime = "+ System.currentTimeMillis()+ " run threadName = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
