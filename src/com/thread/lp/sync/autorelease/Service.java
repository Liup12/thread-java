package com.thread.lp.sync.autorelease;

/**
 * synchronize 关键字修饰的方法内出现异常自动释放锁
 */
public class Service {

    public synchronized void testMethod(){
        if (Thread.currentThread().getName().equals("a")){
            System.out.println("Thread name = " + Thread.currentThread().getName() + "   begin time = " + System.currentTimeMillis());

            while (1==1){
                if ((""+Math.random()).substring(0,8).equals("0.123456")){
                    System.out.println("Thread name = " + Thread.currentThread().getName() + "   run exceptionTime = " + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        }else {
            System.out.println("Thread B run time = " + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);

        threadA.setName("a");
        threadB.setName("b");
        threadA.start();
        threadB.start();
    }
}
