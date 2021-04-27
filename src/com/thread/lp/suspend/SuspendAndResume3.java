package com.thread.lp.suspend;

/**
 *
 *suspend 与 resume方法的确定，独占
 *
 * thread将线程名称改为a,thread2无法进入printString()方法。因为thread拿到了这个printString()方法的锁，并将该线程暂停，thread2线程无法拿到该方法的锁去执行该方法，造成死锁
 *
 * 如果是普通方法则正常执行
 */
public class SuspendAndResume3 {

    public synchronized void printString(){
        System.out.println("printString() begin");
        if (Thread.currentThread().getName().equals("a")){
            System.out.println("线程名称为a的线程被永远 suspend了");
            Thread.currentThread().suspend();
        }
    }

    public void printString2(){
        System.out.println("printString() begin");
        if (Thread.currentThread().getName().equals("a")){
            System.out.println("线程名称为a的线程被永远 suspend了");
            Thread.currentThread().suspend();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final  SuspendAndResume3 synchronizedObject = new SuspendAndResume3();
        Thread thread =  new Thread(){
           @Override
           public void run() {
               synchronizedObject.printString();
           }
        };
        thread.setName("a");
        thread.start();

        Thread.sleep(2000);

        Thread thread2 =  new Thread(){
            @Override
            public void run() {
                System.out.println("thread2线程已经启动，但进入不了printString()方法,只打印一个begin");
                System.out.println("printString()方法已被 a线程锁定并永远suspend暂停了");
                synchronizedObject.printString();
            }
        };
        thread2.setName("a");
        //thread.resume(); //如果thread一直不释放线程(不调用thread的resume()方法,那么这个线程将一直处于挂起状态,)
        thread2.start();


    }
}
