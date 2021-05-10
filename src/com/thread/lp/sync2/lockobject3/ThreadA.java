package com.thread.lp.sync2.lockobject3;

public class ThreadA extends Thread{
    private MyObject object;
    private Service service;

    public ThreadA(MyObject object, Service service) {
        this.object = object;
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod1(object);
    }
}
