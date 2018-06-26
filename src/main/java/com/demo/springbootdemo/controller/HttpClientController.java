package com.demo.springbootdemo.controller;

import com.demo.springbootdemo.util.HttpAPIService;
import com.demo.springbootdemo.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@Slf4j
public class HttpClientController {

    @Resource
    private HttpAPIService httpAPIService;

    @RequestMapping("httpclient")
    public String test() throws Exception {
        String str = httpAPIService.doGet("http://www.baidu.com");
        log.info("测试请求http返回信息：{}",str);
        return "hello";
    }

}
