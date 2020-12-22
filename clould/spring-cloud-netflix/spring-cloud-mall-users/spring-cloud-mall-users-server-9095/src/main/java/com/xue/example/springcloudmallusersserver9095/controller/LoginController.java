package com.xue.example.springcloudmallusersserver9095.controller;


import com.xue.example.api.R;
import com.xue.example.exception.BizException;
import com.xue.example.springcloudmallusersserver9095.biz.AbstractLogin;
import com.xue.example.springcloudmallusersserver9095.biz.Login;
import com.xue.example.springcloudmallusersserver9095.dto.AuthLoginDto;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@RestController
public class LoginController {

    @PostMapping("/login")
    public R loginAuth(@RequestBody @Validated AuthLoginDto authLoginDto, BindingResult bindingResult){
        authLoginDto.validData(bindingResult);
        //登录逻辑?
        Login login= AbstractLogin.loginMap.get(authLoginDto.getLoginType());
        if(login==null){
            throw new BizException("暂不支持该种登录类型");
        }
        return login.doLogin(authLoginDto);
    }
}
