package com.thread.lp.stop;

/**
 * 通过判断当前线程中断状态，可控制for循环退出不去执行
 */
public class Interrupt_Demo2 extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            //this 为当前线程对象
            if (this.isInterrupted()){
                System.out.println("当前线程中断了,让开,我要退出循环了！！！");
                break;
            }
            System.out.println("i = "+ i);

        }

        System.out.println("我是在for循环外面输出的,如果你看到了我,那就证明当前线程并没有退出.......");
    }

    public static void main(String[] args) throws InterruptedException {
        Interrupt_Demo2 thread = new Interrupt_Demo2();
        thread.setName("Interrupt_Demo2");
        thread.start();
        Thread.sleep(200); //当前线程（main线程）休眠200毫秒
        thread.interrupt();
    }
}
