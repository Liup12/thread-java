package com.thread.lp.transdata.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();

        ReadData readData = new ReadData();
        WriteData writeData = new WriteData();

        outputStream.connect(inputStream);
        new Thread(()->{
            writeData.writeData(outputStream);
        }).start();

        Thread.sleep(2000);

        new Thread(()->{
            readData.ReadData(inputStream);
        }).start();
    }
}
