package com.mojo.base.custom;

public class ThreadMain {
    
    
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();
        
        synchronized (b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait(1000);
                System.out.println("b to complete...");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Total is: " + b.total);
        }
    }
}

class ThreadB extends Thread{
    int total;
    
    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 100; i++) {
                total+= i;
            }
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("notify...");
            notify();
        }
    }
}
