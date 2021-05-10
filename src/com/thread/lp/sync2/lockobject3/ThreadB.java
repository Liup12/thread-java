package com.thread.lp.sync2.lockobject3;

public class ThreadB extends Thread{
    private MyObject object;
    private Service service;

    public ThreadB(MyObject object, Service service) {
        this.object = object;
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod1(object);
    }
}
