package com.thread.lp.sync2.syncorder2;

import java.util.ArrayList;
import java.util.List;

public class MyOneList {
    private List list = new ArrayList<>();

    public void add(String data){
        list.add(data);
    }

    public int getSize(){
        return list.size();
    }
}
