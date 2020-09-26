package com.mojo.base.geek;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NumberAndTimeMain {
    
    public static void main(String[] args) {
        threadSafe();
    }
    
    private static void scaleProblem(){
        BigDecimal b1 = new BigDecimal("12.232");
        BigDecimal b2 = b1.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(b2);
        
    }
    
    private static void divide(){
        BigDecimal b1 = new BigDecimal("30");
        BigDecimal b2 = new BigDecimal("7");
        System.out.println(b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP));
        
    }
    
    private static void equalPro(){
        BigDecimal b1 = new BigDecimal("0");
        BigDecimal b2 = new BigDecimal("0.0");
        System.out.println(b1.compareTo(b2));
    }
    
    static ThreadLocal<DateFormat> safeSdf = new ThreadLocal<DateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    
    private static void threadSafe(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,100,1, TimeUnit.MINUTES,new LinkedBlockingDeque<>()
        );
        int i = 0;
        while (i<100){
            threadPoolExecutor.execute(()->{
                String dateString = "2020-01-01 00:00:01";
//                synchronized (sdf){
                    try{
                        Date parseDate = safeSdf.get().parse(dateString);
                        String dateStr = safeSdf.get().format(parseDate);
                        System.out.println(dateStr.equals(dateString));
                    }catch (ParseException e){
                        e.printStackTrace();
                    }
                //}
                
                
            });
            i++;
        }
        threadPoolExecutor.shutdownNow();
    }
}
