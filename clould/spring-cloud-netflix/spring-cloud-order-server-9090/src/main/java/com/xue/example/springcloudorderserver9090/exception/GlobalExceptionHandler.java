package com.xue.example.springcloudorderserver9090.exception;

import com.xue.example.api.R;
import com.xue.example.exception.ValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public R  handlerException(Exception e, HttpServletRequest request){
        log.error("GlobalExceptionHandler.handlerException:{},{}",request.getRequestURI(),e);
        String msg="系统繁忙： "+e.getMessage();
        if(e instanceof ValidException){
            msg=e.getMessage();
        }
        return new R.Builder<>().buildCustomize(msg);
    }

}
