package com.mojo.base.imooc.refl;

public class People {
    
    
    public String people(String hello){
        return People.class.getName() + ":" + hello;
    }
}
