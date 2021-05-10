package com.thread.lp.sync2.lockobject2;

public class Service {
    private String username;
    private String password;
    private String lockString = new String();

    public void doWork(String username, String password){
        try {
            synchronized (lockString){
                System.out.println("线程名称为: " + Thread.currentThread().getName() + " 在" + System.currentTimeMillis()+"进入同步代码块");
                this.username = username;
                Thread.sleep(2000);
                this.password = password;
                System.out.println("username = " + this.username + "   password = " + password);
                System.out.println("线程名称为: " + Thread.currentThread().getName() + " 在" + System.currentTimeMillis()+"离开同步代码块");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.start();
        threadB.start();
    }
}
