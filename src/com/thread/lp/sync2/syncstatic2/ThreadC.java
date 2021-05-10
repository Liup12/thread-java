package com.thread.lp.sync2.syncstatic2;

public class ThreadC extends Thread {
    private Service service;

    public ThreadC(Service service) {

        this.service = service;
    }

    @Override
    public void run() {
        service.printC();
    }
}
