package cn.zhangspace.springbootwebmvc.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "cn.zhangspace.springbootwebmvc.controller")
public class RestControllerAdvicer {

    @ExceptionHandler(value = {NullPointerException.class
            ,IllegalAccessException.class,
            IllegalStateException.class,
    })
    public Object handleNPE(HttpServletRequest request,
            Throwable throwable) {
        Map<String,Object> data = new HashMap<>();
        data.put("adviceMessage",throwable.getMessage());
        return data;
    }


}
