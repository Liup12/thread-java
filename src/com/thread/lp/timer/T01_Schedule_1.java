package com.thread.lp.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/31 16:26
 */
public class T01_Schedule_1 {
    private static Timer timer = new Timer();

    static class TimerC extends TimerTask{

        @Override
        public void run() {
            try {
                System.out.println("定时任务开始Sleep,当前时间为" + new Date());
                Thread.sleep(1000);
                System.out.println("定时任务结束Sleep,当前时间为" + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws ParseException {
        System.out.println(new Date());
        timer.schedule(new TimerC(),2000L,2000);//延时5s  单位: ms

    }

}
