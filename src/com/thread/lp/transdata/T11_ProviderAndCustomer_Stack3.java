package com.thread.lp.transdata;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者消费者一对多（操作栈）
 */
public class T11_ProviderAndCustomer_Stack3 {

    static List list = new ArrayList();

    synchronized void push(){
        try {
            while (list.size() == 1){
                this.wait();
            }
            list.add(Math.random());
            this.notifyAll();
            System.out.println("push = " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    synchronized String pop(){
        String returnVal = "";
        try {
            while (list.size() == 0){
                System.out.println("Pop 操作中"+Thread.currentThread().getName()+" 线程进入wait");
                this.wait();
            }
            returnVal = list.get(0)+"";
            list.remove(0);
            this.notifyAll();
            System.out.println("pop = " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        return returnVal;
    }


    public static void main(String[] args) {
        T11_ProviderAndCustomer_Stack3 stack = new T11_ProviderAndCustomer_Stack3();
        new Thread(()->{
            while (true){
                stack.push();
            }
        },"provider").start();


        new Thread(()->{
            while (true){
                System.out.println("pop = " + stack.pop());
            }
        },"customer").start();

        new Thread(()->{
            while (true){
                System.out.println("pop = " + stack.pop());
            }
        },"customer2").start();

        new Thread(()->{
            while (true){
                System.out.println("pop = " + stack.pop());
            }
        },"customer3").start();
    }
}
