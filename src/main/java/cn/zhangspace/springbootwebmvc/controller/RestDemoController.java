package cn.zhangspace.springbootwebmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDemoController {

    @RequestMapping("/index")
    public String index(){
        return "Hello,World";
    }


}
