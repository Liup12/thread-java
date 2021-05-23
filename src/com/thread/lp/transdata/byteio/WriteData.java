package com.thread.lp.transdata.byteio;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class WriteData {


    public void writeData(PipedWriter writer){
        try {
            System.out.println("write");
            for (int i = 0; i < 30; i++) {
                String s = "" + i;
                writer.write(s);
                System.out.print(s);
            }
            System.out.println();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
