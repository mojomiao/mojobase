package com.mojo.base.imooc;

import com.mojo.base.imooc.refl.Boss;

import java.lang.reflect.Method;

public class ImoocMain {
    public static void main(String[] args) throws Exception {
//        IBaseWorking.time();
//        Worker worker = new Worker();
//        worker.config();
        
        //反射
        //reflectDeMethod();
        refAllMethod();
    }
    
    private static void reflectDeMethod() throws Exception {
        
        Class<Boss> clz = Boss.class;
        
        Method[] methods = clz.getDeclaredMethods();
        
        Method method = clz.getDeclaredMethod("numeric", int.class);
        System.out.println(method);
    }
    
    private static void refAllMethod() throws Exception {
        
        Class<Boss> clz = Boss.class;
        Method method = clz.getMethod("people", String.class);
        System.out.println(method);
    }
    
    private static Method getMethod(Class<?> target, String methodName,
                                    Class<?>[] argTypes) {
        Method method = null;
        try {
            method = target.getDeclaredMethod(methodName, argTypes);
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            //igr
        }
        if (method == null && target != Object.class) {
            return getMethod(target.getSuperclass(), methodName, argTypes);
        }
        
        return method;
    }
}
