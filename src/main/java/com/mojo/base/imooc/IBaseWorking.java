package com.mojo.base.imooc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface IBaseWorking {
    
    void baseCoding();
    
    void baseTesting();
    
    
    static void time(){
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
    }
    
    default void config(){
        System.out.println("base working for config");
    }
}
