package com.thread.lp.transdata.io;

import java.io.IOException;
import java.io.PipedInputStream;


public class ReadData {
    public void ReadData(PipedInputStream inputStream){
        try {
            System.out.println("read:");
            byte[] bytes = new byte[20];
            int read = inputStream.read(bytes);
            while (read != -1){
                System.out.print(new String(bytes,0,read));
                read = inputStream.read(bytes);
            }
            System.out.println();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
