package com.mojo.base.test;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Mojo2Test {
    
    @BeforeAll
    static void initAll(){
        System.out.println("init all");
    }
    
    @BeforeEach
    void init(){
        System.out.println("each");
    }
    
    @Test
    @Order(2)
    void test1(){
        assertTrue(1 == 1);
    }
    
    @Test
    @Order(1)
    void test2(){
        assertTrue(1 == 1);
    }
}
