package com.xue.example.springclouduserserver9091.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean("testClass1")
    TestClass testClass(){
        return new TestClass("testClass1");
    }
    @Qualifier
    @Bean("testClass2")
    TestClass testClass2(){
        return  new TestClass("testClass2");
    }

}
