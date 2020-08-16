package com.mojo.base.custom;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements MyThreadPool<Job> {
    
    
    /**
     * 线程池维护工作者线程的最大数量
     */
    private static final int MAX_WORKER_NUMBERS = 30;
    
    /**
     * 线程池维护工作者线程的最默认工作数量
     */
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    
    /**
     * 线程池维护工作者线程的最小数量
     */
    private static final int MIN_WORKER_NUMBERS = 1;
    
    private final LinkedList<Job> jobs = new LinkedList<>();
    /**
     * 工作者线程的列表
     */
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    
    private int workerNum;
    
    private AtomicLong threadNum = new AtomicLong();
    
    
    public DefaultThreadPool(int num) {
        if (num > MAX_WORKER_NUMBERS) {
            this.workerNum = DEFAULT_WORKER_NUMBERS;
        } else {
            this.workerNum = num;
        }
        initializeWorkers(num);
    }
    
    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker);
            thread.start();
        }
    }
    
    @Override
    public void execute(Job job) {
        
        if (job == null) {
            throw new NullPointerException();
        }
        
        synchronized (jobs) {
            jobs.addLast(job);
            jobs.notify();
        }
    }
    
    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }
    
    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }
    
    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            if (num >= this.workerNum) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < num; i++) {
                Worker worker = workers.get(i);
                if (worker != null) {
                    worker.shutdown();
                    workers.remove(worker);
                }
            }
            this.workerNum -= num;
        }
    }
    
    @Override
    public int getJobSize() {
        return workers.size();
    }
    
    class Worker implements Runnable {
        
        
        private volatile boolean running = true;
        
        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    if (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }//
                    job = jobs.removeFirst();
                }
                
                if (job != null) {
                    job.run();
                }
            }
        }
        
        public void shutdown() {
            running = false;
        }
    }
}
