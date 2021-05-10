package com.thread.lp.sync2.lockobject4;

/**
 * 其他线程执行object对象中synchronize方法呈现同步效果
 * 其他线程执行object对象中synchronize(this)代码块呈现同步效果
 * 原因是因为噶对象锁被某个线程持有，其他线程无法获得其对象锁，形成同步
 */
public class Service {
    public void testMethod1(MyObject object){
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
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject, service);
        ThreadB threadB = new ThreadB(myObject);
        threadA.start();
        threadB.start();
    }
}
