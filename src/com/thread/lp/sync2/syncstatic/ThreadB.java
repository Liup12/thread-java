package com.thread.lp.sync2.syncstatic;

public class ThreadB extends Thread {
    @Override
    public void run() {
        Service.printB();
    }
}
