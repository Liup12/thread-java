package com.thread.lp.sync2.syncstatic;

public class ThreadA extends Thread {
    @Override
    public void run() {
        Service.printA();
    }
}
