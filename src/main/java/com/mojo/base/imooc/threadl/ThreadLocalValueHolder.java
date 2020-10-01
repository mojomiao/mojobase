package com.mojo.base.imooc.threadl;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalValueHolder {
    
    private static final ThreadLocal<Integer> holder = ThreadLocal.withInitial(
            () -> 0
    );
    
    public static int getVal() {
        return holder.get();
    }
    
    public static void setVal(int value) {
        holder.set(value);
    }
    
    public static void remove() {
        holder.remove();
    }
    
    public static void increment() {
        holder.set(holder.get() + 1);
    }
    
    public static void main(String[] args) {
    
        ExecutorService es = Executors.newFixedThreadPool(3);
    
    
        for (int i = 0; i < 15; i++) {
            es.execute(()->{
                try {
                    long threadId = Thread.currentThread().getId();
                    int before = getVal();
                    increment();
                    int after = getVal();
    
                    System.out.println(threadId+" :before: " + before + ", after: " +after);
                }finally {
                    remove();
                }
                
            });
        }
        es.shutdown();
        
    }
}
