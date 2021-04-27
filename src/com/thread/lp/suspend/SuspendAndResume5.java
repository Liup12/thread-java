package com.thread.lp.suspend;

/**
 * 缺点：数据不同步问题
 *
 */
public class SuspendAndResume5 {

    private String username = "a";
    private String password = "aaaa";

    public void setValue(String username, String password){
        this.username = username;
        if (Thread.currentThread().getName().equals("a")){
            System.out.println("停止a线程");
            Thread.currentThread().suspend();
        }
        this.password = password;
    }

    public void printUsernameAndPassword(){
        System.out.println(username+"  " + password);
    }

    public static void main(String[] args) {
        final SuspendAndResume5 resume5 = new SuspendAndResume5();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                resume5.setValue("b","bbbbb");
            }
        };

        thread1.setName("a");
        thread1.start();

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                resume5.printUsernameAndPassword();
            }
        };
        thread2.start();



    }

}
