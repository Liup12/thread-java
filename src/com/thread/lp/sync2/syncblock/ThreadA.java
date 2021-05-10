package com.thread.lp.sync2.syncblock;

public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceMethodA();
    }
}
