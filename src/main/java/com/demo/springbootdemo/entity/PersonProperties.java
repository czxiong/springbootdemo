package com.demo.springbootdemo.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 获取配置文件中的属性值
 */
@Component
@ConfigurationProperties(prefix = "person")
//使用lombok的@Data注解可以减少set、get等一系列方法
@Data
public class PersonProperties {

    private String name;

    private Integer age;

}
