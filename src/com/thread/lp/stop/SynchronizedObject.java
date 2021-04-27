package com.thread.lp.stop;

public class SynchronizedObject {
    private String name = "a";
    private String pwd  = "aaaaa";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public synchronized void printString(String username,  String password){

        try {
            this.name  = username;
            Thread.sleep(100000000);
            this.pwd = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
