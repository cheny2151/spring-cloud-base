package com.cheney.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerHandler {

    @ExceptionHandler
    @ResponseBody
    public String errorPage(Exception e) {
        e.printStackTrace();
        return "error";
    }

}
