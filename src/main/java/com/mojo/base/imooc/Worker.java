package com.mojo.base.imooc;

/**
 * 员工类
 */
public class Worker extends BaseWork implements IBaseWorking, IExtraWorking{
    
    private int wakeUpTime = 10;
    
    @Override
    protected void clockIn() {
    
    }
    
    @Override
    protected void clockOut() {
    
    }
    
    @Override
    public void baseCoding() {
    
    }
    
    @Override
    public void baseTesting() {
    
    }
    
    @Override
    public void extraCoding() {
    
    }
    
    @Override
    public void extraTesting() {
    
    }
    
    @Override
    public void config() {
        System.out.println("worker config");
    }
}
