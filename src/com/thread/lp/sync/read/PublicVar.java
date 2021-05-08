package com.thread.lp.sync.read;

/**
 * （1）当getValue方法未加synchronize关键字时，threadA线程首先获得该对象的锁,执行run方法，将username字段赋值后休眠2秒
 * 此时main线程执行publicVar对象的getValue，得到修改后的username和未修改的password;
 *
 * 打印信息：
 * getValue method thread name = main username = B    password = AAAA
 * setValue method thread name  = Thread-0 username = B    password = BBB
 *
 * （2）当getValue方法加上了synchronize关键字，thread1线程首先获得该对象的锁,执行run方法，将username字段赋值后休眠2秒
 * 此时main线程将执行publicVar对象的getValue()方法,但无法获取到publicVar对象的锁，需等待threadA释放publicVar对象的锁
 * 待threadA释放锁之后，main线程才会执行getValue()方法
 *
 * 打印信息：
 * setValue method thread name  = Thread-0 username = B    password = BBB
 * getValue method thread name = main username = B    password = BBB
 */
public class PublicVar {
    private String username = "A";
    private String password = "AAAA";

    public synchronized void setValue(String username, String password){
        try {
            this.username = username;
            Thread.sleep(2000);
            this.password = password;
            System.out.println("setValue method thread name  = " + Thread.currentThread().getName() + " username = "+ username +"    password = " + password);
        }catch (InterruptedException e){
           e.printStackTrace();
        }
    }

    public synchronized   void getValue(){
        System.out.println("getValue method thread name = " + Thread.currentThread().getName() + " username = "+ username +"    password = " + password);
    }


    public static void main(String[] args) {

        try {
            PublicVar publicVar = new PublicVar();
            ThreadA threadA = new ThreadA(publicVar);
            threadA.start();
            Thread.sleep(11);
            publicVar.getValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
