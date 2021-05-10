package com.thread.lp.sync2.lockobject2;

public class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.doWork("B","BBB");
    }
}
