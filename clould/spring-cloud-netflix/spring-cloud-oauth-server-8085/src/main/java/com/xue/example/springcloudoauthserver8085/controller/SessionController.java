package com.xue.example.springcloudoauthserver8085.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Value("${server.port}")
    Integer port;
    @GetMapping("/set")
    public String setValue(HttpSession httpSession){
        httpSession.setAttribute("test","test.com");
        return port.toString();
    }
    @GetMapping("/get")
    public String getValue(HttpSession httpSession){
        return httpSession.getAttribute("test").toString()+port;
    }
}
