package com.mojo.base;

import java.util.ArrayList;
import java.util.List;

public class MojoMain {
    
    
    public static void main(String[] args) {
        System.err.println("hello");
        List<String> list = new ArrayList<>();
        
        list.add("a");
        
        
        
        
        list.add("b");
        
        for (String s : list) {
            System.err.println(s);
        }
    
    
        for (String s : args) {
            System.out.println(s);
        }
        
        Thread thread = new Thread(() -> {
        
        });
        
        Student student = new Student();
        
        student.setAge(11);
        student.setName("miao");
        System.out.println(student);
    
        try {
            Class.forName("com.mojo.base.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Student {
    private String name;
    
    private int age;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
