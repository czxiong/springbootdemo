package com.demo.springbootdemo.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
//如果类名称和表一直，则可以去掉
@Table(name = "person")
@Data
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

}
