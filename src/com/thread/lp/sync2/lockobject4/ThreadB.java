package com.thread.lp.sync2.lockobject4;


public class ThreadB extends Thread{
    private MyObject object;


    public ThreadB(MyObject object) {
        this.object = object;

    }

    @Override
    public void run() {
        object.myObjectMethod();
    }
}
