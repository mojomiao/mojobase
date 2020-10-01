package com.mojo.base.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Stu {
    
    private String name;
    
    private int age;
    
    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
