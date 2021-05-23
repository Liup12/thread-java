package com.thread.lp.transdata;

/**
 *
 *
 * 就此结果分析运行流程
 * 生产者provider1RUNNABLE了    线程启动 early notify
 * 生产者provider1WAITING了     wait
 * 消费者customer2RUNNABLE了    线程启动 notify  provider1被唤醒
 * 消费者customer2WAITING了     wait
 * 消费者customer1WAITING了     线程启动 wait
 * 生产者provider2RUNNABLE了    线程启动 notify  随机唤醒customer1或者customer2
 * 生产者provider2WAITING了      wait
 * 消费者customer2RUNNABLE了    收到notify  notify
 * 消费者customer2WAITING了     wait
 * 消费者customer1WAITING了     收到notify wait
 * 生产者provider1RUNNABLE了    收到notify  notify
 * 生产者provider1WAITING了     wait
 * 生产者provider2WAITING了     收到notify wait
 * Thread name = main and Thread status = RUNNABLE
 * Thread name = Monitor Ctrl-Break and Thread status = RUNNABLE
 * Thread name = provider1 and Thread status = WAITING
 * Thread name = provider2 and Thread status = WAITING
 * Thread name = customer1 and Thread status = WAITING
 * Thread name = customer2 and Thread status = WAITING
 *
 * 1、provider1线程被启动了，执行完生产代码，发出通知，但此时为提前通知，并没有其他持有lock锁的线程处于wait状态，此时状态为RUNNABLE
 * 2、provider1继续执行循环，判断当前信息还未被消费，进入wait状态并释放锁。此时状态为WAITING
 * 3、customer2抢到了锁，执行消费。并发出通知notify，此时状态为RUNNABLE
 * 4、customer2循环第二次消费并未消费到消息，进入wait状态并释放锁。此时状态为WAITING
 * 5、customer1抢到锁，执行消费，但未消费到消息，进入wait状态并释放锁，此时状态WAITING
 * 6、provider2启动。获得lock，生产消息。此时状态为RUNNABLE
 * 7、provider2再次循环生产消息，此时还有消息未被消费，进入等待，状态为wait
 * 8、customer2抢到了锁，执行消费。并发出通知notify，此时状态为RUNNABLE
 * 9、customer2循环第二次消费并未消费到消息，进入wait状态并释放锁。此时状态为WAITING
 * 10、customer1抢到锁，执行消费，但未消费到消息，进入wait状态并释放锁，此时状态WAITING
 * 11、provider2生产消息，并发送通知此时状态为RUNNABLE
 * 12、provider2继续执行循环，判断当前信息还未被消费，进入wait状态并释放锁。此时状态为WAITING
 * 13、provider1接收到通知，发现有消息未消费，进入wait状态。此时状态为WAITING。
 *
 * 假死出现的问题是因为，期待某个线程未能发出notify通知，但是当前线程却wait了，造成假死
 */
public class T11_ProviderAndCustomer_Value2 {
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
                            lock.notify(); //通知消费者 容易造成线程假死状态
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
                            lock.notify(); //通知生产者
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
