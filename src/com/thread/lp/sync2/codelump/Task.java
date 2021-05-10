package com.thread.lp.sync2.codelump;

public class Task {
    private String getData1;
    private String getData2;

    public void doWork(){
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String priGetData1 = "长时间处理任务后返回值1  threadName= " + Thread.currentThread().getName();
            String priGetData2 = "长时间处理任务后返回值2  threadName= " + Thread.currentThread().getName();
            synchronized (this){
                getData1 = priGetData1;
                getData2 = priGetData2;
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end Task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
