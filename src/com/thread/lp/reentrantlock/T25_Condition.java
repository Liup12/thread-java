package com.thread.lp.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition实现顺序打印
 * @author liupei
 * @version 1.0
 * @date 2021/5/31 15:47
 */
public class T25_Condition {
    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();


    volatile private static int index = 1;

    public void method1(){
        try {
            while (true){
                lock.lock();
                while (index != 1){
                    condition1.await();
                }
                System.out.println(Thread.currentThread().getName()+" is running method1");
                index = 2;
                condition2.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void method2(){
        try {
            while (true){
                lock.lock();
                while (index != 2){
                    condition2.await();
                }
                index = 3;
                System.out.println(Thread.currentThread().getName()+" is running method2");
                condition3.signalAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void method3(){
        try {
            while (true){
                lock.lock();
                while (index != 3){
                    condition3.await();
                }
                index = 1;
                System.out.println(Thread.currentThread().getName()+" is running method3");
                condition1.signalAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



    public static void main(String[] args) {
        T25_Condition service = new T25_Condition();
        new Thread(()-> service.method2()).start();
        new Thread(()-> service.method3()).start();

        new Thread(()-> service.method1()).start();


    }
}
