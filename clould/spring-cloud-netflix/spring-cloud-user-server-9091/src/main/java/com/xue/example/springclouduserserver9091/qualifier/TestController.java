package com.xue.example.springclouduserserver9091.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    @Qualifier
    List<TestClass> testClassList= Collections.emptyList();


    @GetMapping("/test")
    public Object getTest() {
        return testClassList;
    }
}
