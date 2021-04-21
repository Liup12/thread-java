package com.thread.lp.current;


/**
 * 首先，子类的构造函数如果没有显式地指定调用父类的哪个构造方法，则在子类构造方法的第一行默认调用父类无参构造器，即隐式地调用super()；
 * 其次，实例化子类要先实例化父类。本例中MyThread2是Thread的子类，而子类中没有重写父类的getName()方法
 * （事实上，Thread类的getName()方法被final修饰不能被重写）
 * 所以在代码第19行的this.getName()调用的是父类的方法。
 * 前面已提到在实例化子类之前要先实例化父类，也就是说对于本例会先调用父类的默认构造器：
 *
 * Thread源码中  line369： this.name = name.toCharArray();  将父类的线程name设置为当前线程名 ，固23行输出thread-0
 */

/**
 * @author Administrator
 */
public class MyThread2 extends Thread{

    public MyThread2() {
        super();
        System.out.println("Constructor begin......");
        //在new MyThread() 时候由 main 线程调用，所以当前线程为main
        System.out.println("Constructor execute by " + Thread.currentThread().getName());
        //调用此代码块的时候，是main线程,main线程属于活跃状态 true
        System.out.println("Constructor Thread.currentThread().isAlive() "+ Thread.currentThread().isAlive());
        //this是指当前对象，这里在demo中指的是thread2这个对象,如果不对thread2这个对象的name赋值，那么当前对象的name默认为父类的name = “thread-0”
        System.out.println("Constructor this.getName() "+ this.getName());
        //调用此代码块的时候，是main线程，所以当前线程属于不活状态   //false
        System.out.println("Constructor this.isAlive() "+ this.isAlive());
        System.out.println("Constructor end......");
    }


    @Override
    public void run() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("run begin......");
        //当前执行此run方法的线程名称，demo中为thread,name为"AAAA"
        System.out.println("run execute by " + Thread.currentThread().getName());
        //当前执行此run方法的线程为thread，此线程为活跃状态 true
        System.out.println("run Thread.currentThread().alive() "+ Thread.currentThread().isAlive());
        //this指当对象，当前对象为thread2，名称为父类线程名称 ： "thread-0"
        System.out.println("run this.getName() "+ this.getName());
        //thread2由thread线程代理执行,固thread2非活跃 false
        System.out.println("run this.alive() "+ this.isAlive());
        //当前线程类   java.lang.Thread
        System.out.println("run Thread.currentThread().getClass().getName() = " + Thread.currentThread().getClass().getName());
        //当前对象的class
        System.out.println("run this.getClass().getName() = " + this.getClass().getName());
        System.out.println("run end......");
    }

    @Override
    public String toString() {
        return "MyThread2{}";
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread2 thread2 = new MyThread2();
       /* Thread thread = new Thread(thread2);
        thread.setName("AAAA");
        thread.start();*/
        thread2.setName("AAAA");
        thread2.start();
    }
}
