package com.thread.lp.transdata;

/**
 * 使用notifyAll()方法可解决多生产多消费的问题
 */
public class T11_ProviderAndCustomer_Value3 {
    static String s = "";


    public static void main(String[] args) throws InterruptedException {
        String lock = "";
        Runnable provider = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        synchronized (lock){
                            while (!s.equals("")){
                                System.out.println("生产者"+ Thread.currentThread().getName() +"WAITING了");
                                lock.wait();
                            }
                            System.out.println("生产者"+ Thread.currentThread().getName() +"RUNNABLE了");
                            s = System.currentTimeMillis()+"_" +System.nanoTime();
                            lock.notifyAll(); //通知所有  避免出现假死状态
                        }
                    }

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        Runnable customer = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        synchronized (lock){
                            while (s.equals("")){
                                System.out.println("消费者"+ Thread.currentThread().getName() +"WAITING了");
                                lock.wait();
                            }
                            System.out.println("消费者"+ Thread.currentThread().getName() +"RUNNABLE了");
                            s = "";
                            lock.notifyAll(); //通知生产者 避免出现假死状态
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread provider1 = new Thread(provider);
        provider1.setName("provider1");
        Thread provider2 = new Thread(provider);
        provider2.setName("provider2");
        Thread customer1 = new Thread(customer);
        customer1.setName("customer1");
        Thread customer2 = new Thread(customer);
        customer2.setName("customer2");

        provider1.start();
        provider2.start();
        customer1.start();
        customer2.start();

        Thread.sleep(5000);
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);

        for (int i = 0; i < threadArray.length; i++) {
            System.out.println("Thread name = "+ threadArray[i].getName() + " and Thread status = " + threadArray[i].getState());
        }
    }
}
