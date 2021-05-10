package com.thread.lp.sync2.lockobject3;

public class Service {
    public void testMethod1(MyObject object){
        System.out.println(" run testMethod1 time = "+ System.currentTimeMillis() + "threadName =" + Thread.currentThread().getName());
        synchronized (object){
            try {
                System.out.println("testMethod1 _getLockTime = "+ System.currentTimeMillis()+ " run threadName = " + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod1 releaseLockTime = "+ System.currentTimeMillis()+ " run threadName = " + Thread.currentThread().getName());
            }catch (InterruptedException e){

            }
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        //虽然threadA线程和threadB线程操作不同的service对象,但MyObject对象锁首先被ThreadA持有，ThreadB需等ThreadA释放锁才能进入同步代码块
        Service service2 = new Service();
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject, service);
        ThreadB threadB = new ThreadB(myObject, service2);
        threadA.start();
        threadB.start();
    }
}
