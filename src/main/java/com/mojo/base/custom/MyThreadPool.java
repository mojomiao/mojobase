package com.mojo.base.custom;

public interface MyThreadPool<Job extends Runnable> {
    
    
    public void execute(Job job);
    
    public void shutdown();
    
    void addWorkers(int num);
    
    void removeWorker(int num);
    
    int getJobSize();
    
}
