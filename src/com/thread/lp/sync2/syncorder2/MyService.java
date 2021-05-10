package com.thread.lp.sync2.syncorder2;


public class MyService {
    public MyOneList addServiceMethod(MyOneList list, String data){
        try {
            synchronized (list){
                System.out.println("当前线程 = "+Thread.currentThread().getName() + "进入serviceMethod方法");
                if (list.getSize() < 1){
                    Thread.sleep(3000);
                    list.add(data);
                }
                System.out.println("当前线程 = "+Thread.currentThread().getName() + "退出serviceMethod方法");
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        MyOneList myOneList = new MyOneList();
        ThreadA threadA = new ThreadA(myOneList);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(myOneList);
        threadB.setName("B");
        threadA.start();
        threadB.start();
        Thread.sleep(8000);
        System.out.println(myOneList.getSize());
    }
}
