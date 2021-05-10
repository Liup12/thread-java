package com.thread.lp.sync2.syncmethod;

public class Task {
    private String getData1;
    private String getData2;

    public synchronized void doWork(){
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            getData1 = "长时间处理任务后返回值1  threadName= " + Thread.currentThread().getName();
            getData2 = "长时间处理任务后返回值2  threadName= " + Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end Task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
