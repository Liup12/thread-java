package com.thread.lp.sync2.codelump;

public class ThreadA extends Thread {
    private Task task;

    public ThreadA(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doWork();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}
