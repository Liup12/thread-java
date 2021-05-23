package com.thread.lp.transdata.io;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {


    public void writeData(PipedOutputStream outputStream){
        try {
            System.out.println("write");
            for (int i = 0; i < 30; i++) {
                String s = "" + i;
                outputStream.write(s.getBytes());
                System.out.print(s);
            }
            System.out.println();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
