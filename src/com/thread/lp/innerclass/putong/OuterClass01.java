package com.thread.lp.innerclass.putong;

public class OuterClass01 {
    private String username;
    public void say(){
        username = "OuterClass01";
        System.out.println("outer class");
    }

    class InnerClass01{

        public void say(){
            System.out.println("inner class by "+ username);
        }
    }


    public static void main(String[] args) {
        OuterClass01 outerClass01 = new OuterClass01();
        InnerClass01 innerClass01 = outerClass01.new InnerClass01();
        outerClass01.say();
        innerClass01.say();
    }
}
