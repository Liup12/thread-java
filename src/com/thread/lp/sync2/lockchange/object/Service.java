package com.thread.lp.sync2.lockchange.object;

/**
 * 只要对象不变，即使对象的属性发生了改变，锁也不会改变
 */
public class Service {

    public void serviceMethod(User user){
        synchronized (user){
            try {
                System.out.println("当前线程"+Thread.currentThread().getName()+"进入serviceMethod方法");
                //线程A拿到lock锁，当线程B启动
                //1、如果再lock未发生变更之前去获取锁，那么这个锁就是A线程所持有的锁"123"，两个线程同步执行
                //2、如果在lock发生变更之后去获取锁，那么就会获取一个新的锁"345",两个线程会异步执行
                //此处sleep是为了确保线程B在线程A的lock锁未修改之前启动，与线程A去争夺这个lock锁
                Thread.sleep(20);
                user.setUsername("BBB");

                Thread.sleep(2000);
                System.out.println("当前线程"+Thread.currentThread().getName()+"离开serviceMethod方法");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }



    static class User {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }


    static class ThreadA extends Thread{
        private Service service;
        private User user;

        public ThreadA(Service service, User user) {
            this.service = service;
            this.user = user;
        }

        @Override
        public void run() {
            service.serviceMethod(user);
        }
    }

    static class ThreadB extends Thread{
        private Service service;
        private User user;

        public ThreadB(Service service, User user) {
            this.service = service;
            this.user = user;
        }

        @Override
        public void run() {
            service.serviceMethod(user);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        Service service = new Service();
        ThreadA threadA = new ThreadA(service, user);
        ThreadB threadB = new ThreadB(service, user);
        threadA.start();
        Thread.sleep(2000);
        threadB.start();
    }
}
