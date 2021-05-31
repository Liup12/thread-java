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
public class T01_Schedule_2 {
    private static Timer timer = new Timer();

    static class TimerC extends TimerTask{

        @Override
        public void run() {
            System.out.println("定时任务已经运行了,当前时间为" + new Date());
        }
    }


    public static void main(String[] args) throws ParseException {
       /* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = "2021-5-31 16:32:00";
        Date parse = dateFormat.parse(string);*/
        System.out.println(new Date());
        timer.schedule(new TimerC(),5000L,2000);//延时5s  单位: ms

    }

}
