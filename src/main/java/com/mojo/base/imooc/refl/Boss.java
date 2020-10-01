package com.mojo.base.imooc.refl;

public class Boss extends MyWorker{
    
    public String boss(String hello){
        return Boss.class.getName() + ":" + hello;
    }
    
    public String numeric(int age){
        return Boss.class.getName() + ":" + age;
    }
}
