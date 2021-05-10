package com.thread.lp.sync2.syncblock;

public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceMethodB();
    }
}
