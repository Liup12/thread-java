package com.thread.lp.sync2.lockobject2;

public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {

        service.doWork("A","AAA");
    }
}
