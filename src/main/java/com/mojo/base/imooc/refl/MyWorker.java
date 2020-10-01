package com.mojo.base.imooc.refl;

import com.mojo.base.imooc.Worker;

public class MyWorker extends People {
    
    public String worker(String hello) {
        return Worker.class.getName() + ":" + hello;
    }
}
