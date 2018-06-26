package com.demo.springbootdemo.controller;

import com.demo.springbootdemo.entity.PersonProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HelloController {

    @Resource
    private PersonProperties personProperties;

    @Value("${http.maxTotal}")
    private String maxTotal;

    @GetMapping("/hello")
    public String say(){
        log.info("获取到配置文件中的http配置参数：{}",maxTotal);
        return "Hello SpringBoot";
    }

    @GetMapping("/getValue")
    public String getPropertiessValue(){
        return personProperties.getName()+"-"+personProperties.getAge();
    }

}
