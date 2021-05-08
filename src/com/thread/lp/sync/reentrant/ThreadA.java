package com.thread.lp.sync.reentrant;

public class ThreadA extends Thread {
    Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {

        service.service1();
    }
}
