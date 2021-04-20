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
        System.out.println("Constructor execute by " + Thread.currentThread().getName());
        System.out.println("Constructor this.getName() "+ this.getName());
        System.out.println("Constructor Thread.currentThread().isAlive() "+ Thread.currentThread().isAlive());
        System.out.println("Constructor this.isAlive() "+ this.isAlive());
        System.out.println("Constructor end......");
    }


    @Override
    public void run() {
        System.out.println("run begin......");
        System.out.println("run execute by " + Thread.currentThread().getName());
        System.out.println("run this.getName() "+ this.getName());
        System.out.println("run Thread.currentThread().alive() "+ Thread.currentThread().isAlive());
        System.out.println("run this.alive() "+ this.isAlive());
        System.out.println("run Thread.currentThread().getClass().getName() = " + Thread.currentThread().getClass().getName());
        System.out.println("run this.getClass().getName() = " + this.getClass().getName());
        System.out.println("run end......");
    }

    @Override
    public String toString() {
        return "MyThread2{}";
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread2 thread2 = new MyThread2();
        Thread thread = new Thread(thread2);
        thread.setName("AAAA");
        thread.start();
    }
}
