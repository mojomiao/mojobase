package com.mojo.base.test;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@DisplayNameGeneration(TimeUtils2Test.ReplaceUnderscores.class)
public class TimeUtils2Test {
    
    
    @Test
    void hello(){
        Instant now = Instant.now();
        String expect = "现在的时间是:"+now.toString();
        System.out.println(expect);
    }
    
    
    static class ReplaceUnderscores extends DisplayNameGenerator.ReplaceUnderscores{
    
        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            System.out.println(testClass.getCanonicalName());
            return "哈哈哈";
        }
    }
    
}
