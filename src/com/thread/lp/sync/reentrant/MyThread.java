package com.thread.lp.sync.reentrant;

public class MyThread extends Thread{
    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateSubMethod();
    }
}
