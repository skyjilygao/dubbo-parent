package com.demo.dubboconsumer.controller;

//import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.common.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

    @Reference(version = "1.0")
    private DemoService demoService;

    @RequestMapping("/hello")
    public String hello(){
        return demoService.hello();
    }

}