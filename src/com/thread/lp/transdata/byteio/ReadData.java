package com.thread.lp.transdata.byteio;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;


public class ReadData {

    public void ReadData(PipedReader reader){
        try {
            System.out.println("read:");
            char[] chars = new char[20];
            int read = reader.read(chars);
            while (read != -1){
                System.out.print(new String(chars,0,read));
                read = reader.read(chars);
            }
            System.out.println();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
