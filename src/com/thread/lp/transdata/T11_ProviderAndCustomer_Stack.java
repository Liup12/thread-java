package com.thread.lp.transdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 生产者消费者一对一（操作栈）
 */
public class T11_ProviderAndCustomer_Stack {

    static List list = new ArrayList();

    synchronized void push(){
        try {
            while (list.size() == 1){
                this.wait();
            }
            list.add(Math.random());
            this.notify();
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
            this.notify();
            System.out.println("pop = " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        return returnVal;
    }


    public static void main(String[] args) {
        T11_ProviderAndCustomer_Stack stack = new T11_ProviderAndCustomer_Stack();
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
    }
}
