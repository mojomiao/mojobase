package com.mojo.base.tree;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Mojo extends Stu {
    
    private int high;
    
    public Mojo(String name, int age, int high) {
        super(name, age);
        this.high = high;
    }
}
