package com.mojo.base.imooc;

public class ImoocMain {
    public static void main(String[] args) {
        IBaseWorking.time();
        Worker worker = new Worker();
        worker.config();
    }
}
