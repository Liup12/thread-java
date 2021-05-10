package com.thread.lp.sync2.syncorder2;

public class ThreadB extends Thread{

    private MyOneList list;

    public ThreadB(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        MyService myService = new MyService();
        myService.addServiceMethod(list,"B");
    }
}
