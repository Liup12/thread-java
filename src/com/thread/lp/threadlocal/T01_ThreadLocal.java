package com.thread.lp.threadlocal;

import java.util.HashMap;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 11:17
 */
public class T01_ThreadLocal {

    private static ThreadLocal<HashMap<String,Object>> l = new ThreadLocal();
    public static void main(String[] args) {
        if (l.get() ==null){
            System.out.println("还未存放值");
            HashMap<String, Object> map = new HashMap<>();
            map.put("1","1");
            map.put("2","2");
            map.put("3","3");
            map.put("4","4");
            map.put("5","5");
            l.set(map);
        }

        l.get().forEach((k,v) ->{
            System.out.println("key = " + k + " , value = " + v );
        });
    }
}
