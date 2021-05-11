package com.thread.lp.sync2.lockchange.string;

/**
 * lock被修改为"345"之后，锁对象发生了改变
 */
public class Service {

    private String lock = "123";


    public void serviceMethod(){
        synchronized (lock){
            try {
            System.out.println("当前线程"+Thread.currentThread().getName()+"进入serviceMethod方法");
            //线程A拿到lock锁，当线程B启动
            //1、如果再lock未发生变更之前去获取锁，那么这个锁就是A线程所持有的锁"123"，两个线程同步执行
            //2、如果在lock发生变更之后去获取锁，那么就会获取一个新的锁"345",两个线程会异步执行
            //此处sleep是为了确保线程B在线程A的lock锁未修改之前启动，与线程A去争夺这个lock锁
            Thread.sleep(20);
            lock = "345";
            Thread.sleep(2000);
            System.out.println("当前线程"+Thread.currentThread().getName()+"离开serviceMethod方法");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    static class ThreadA extends Thread{
        private Service service;

        public ThreadA(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.serviceMethod();
        }
    }

    static class ThreadB extends Thread{
        private Service service;

        public ThreadB(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.serviceMethod();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.start();
        // 此处加上sleep是为了确保线程A已经将lock锁变更了，ThreadB拿到的一定是新的锁，两个线程会异步执行
        // 去掉则会同步执行
        Thread.sleep(2000);
        threadB.start();
    }
}
