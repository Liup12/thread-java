package com.thread.lp.sync2.syncorder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List list = new ArrayList();

    public synchronized void add(String username){
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " 执行了add方法");
        list.add(username);
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " 退出了add方法");
    }

    public int size(){
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " 执行了size方法");
        int size = list.size();
        System.out.println("ThreadName = " + Thread.currentThread().getName() + " 退出了size方法");
        return size;
    }

    public static void main(String[] args) {
        MyList myList = new MyList();
        ThreadA threadA = new ThreadA(myList);
        ThreadB threadB = new ThreadB(myList);
        threadA.start();
        threadB.start();
    }
}
