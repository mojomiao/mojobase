package com.mojo.base.test;

import com.mojo.base.leetcode.Lc38;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MojoTest {
    
    @DisplayName("Test Add")
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void test1() {
        int a = 111;
        int b = 111;
        assertEquals(a, b);
    }
    
    @DisplayName("Test Lc38")
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void test2() {
        
        assertEquals(Lc38.bitSum(19), 10);
        assertEquals(Lc38.bitSum(1119), 12, "数位和运算");
    }
    
    @DisplayName("参数注入测试")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "bbb", "ccc"})
    public void test3(String param) {
        
        assertEquals(param.length(), 3);
    }
    
    @DisplayName("参数注入测试2")
    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void testWithArgumentsSource(String argument) {
        assertTrue(String.class.isAssignableFrom(argument.getClass()));
    }
    static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of("apple", "banana").map(Arguments::of);
        }
    }
}
