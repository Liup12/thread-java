package com.thread.lp.transdata;

public class T11_ProviderAndCustomer_Value {
    static String s = "";
    static class Provider implements Runnable{
        private String lock;

        public Provider(String lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {

                while (true){
                    synchronized (lock){
                        if (!s.equals("")){
                            lock.wait();
                        }
                        s = System.currentTimeMillis()+"_"+System.nanoTime();
                        System.out.println("生产："+ s);
                        lock.notify();
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Customer implements Runnable{
        private String lock;

        public Customer(String lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
            try {

                while (true){
                    synchronized (lock){
                    if (s.equals("")){

                        lock.wait();
                    }
                    System.out.println("消费到S的值是：" + s);
                    s = "";
                    lock.notify();
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        String lock = "";
        Provider provider = new Provider(lock);
        Customer customer = new Customer(lock);

        Thread pro = new Thread(provider);
        Thread cus = new Thread(customer);

        pro.setName("Provider");
        cus.setName("Customer");

        pro.start();
        cus.start();

    }
}
