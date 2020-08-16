package com.mojo.base.test;

import com.mojo.base.leetcode.Lc38;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MojoTest {
    
    @DisplayName("Test Add")
    @Test
    public void test1(){
        int a = 111;
        int b = 111;
        assertEquals(a, b);
    }
    
    @DisplayName("Test Lc38")
    @Test
    public void test2(){
        assertEquals(Lc38.bitSum(19), 10);
        assertEquals(Lc38.bitSum(1119), 12);
    }
}
