package com.thread.lp.transdata.byteio;


import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();

        ReadData readData = new ReadData();
        WriteData writeData = new WriteData();

        reader.connect(writer);
        new Thread(()->{
            writeData.writeData(writer);
        }).start();

        Thread.sleep(2000);

        new Thread(()->{
            readData.ReadData(reader);
        }).start();

    }
}
