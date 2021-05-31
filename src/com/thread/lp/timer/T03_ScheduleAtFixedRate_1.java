package com.thread.lp.timer;

import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liupei
 * @version 1.0
 * @date 2021/5/31 16:26
 */
public class T03_ScheduleAtFixedRate_1 {
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
       /* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = "2021-5-31 16:32:00";
        Date parse = dateFormat.parse(string);*/
        System.out.println(new Date());
        timer.scheduleAtFixedRate(new TimerC(),5000L,5000);//延时5s  单位: ms

    }

}
