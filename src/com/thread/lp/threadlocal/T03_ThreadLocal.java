package com.thread.lp.threadlocal;

import java.util.HashMap;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 11:17
 */
public class T03_ThreadLocal {

    private static ThreadLocalE l = new ThreadLocalE();



    public static void main(String[] args) {
        if (l.get() ==null){
            System.out.println("还未存放值");
            l.set("hello");
        }
        System.out.println(l.get());

    }

    static class ThreadLocalE extends ThreadLocal{
        @Override
        protected Object initialValue() {
            return "initValue";
        }
    }

}
