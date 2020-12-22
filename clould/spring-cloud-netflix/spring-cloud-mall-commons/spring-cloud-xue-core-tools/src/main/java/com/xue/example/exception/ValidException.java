package com.xue.example.exception;

public class ValidException extends BaseException{

    public ValidException() {
        super();
    }


    public ValidException(String message) {
        super(message);
        this.msg=message;
    }

    public ValidException(String message, String code) {
        super(message, code);
        this.msg=message;
        this.code=code;
    }
}
