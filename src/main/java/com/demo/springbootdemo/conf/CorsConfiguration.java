package com.demo.springbootdemo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 跨域请求配置类，解决跨域请求问题
 */
@Configuration
public class CorsConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                //允许所有的请求
                //.allowedMethods("*")
                //允许指定的请求
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedOrigins("*")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
