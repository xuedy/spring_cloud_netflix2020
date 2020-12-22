package com.xue.example.springcloudmallusersserver9095.biz;


import com.xue.example.api.R;
import com.xue.example.exception.BizException;
import com.xue.example.springcloudmallusersserver9095.dto.AuthLoginDto;

public interface Login {

    R doLogin(AuthLoginDto authLoginDto) throws BizException;
}
