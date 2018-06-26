package com.demo.springbootdemo.controller;

import com.demo.springbootdemo.entity.Person;
import com.demo.springbootdemo.repository.PersonRepository;
import com.demo.springbootdemo.service.PersonService;
import com.demo.springbootdemo.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "用户控制层")
@CrossOrigin  //解决跨域请求
@Slf4j //lombok的日志插件
public class PersonController {

    @Resource
    private PersonRepository personRepository;

    @Resource
    private PersonService personService;

    @Resource
    private RedisUtils redisUtils;

    @PostMapping(value = "/list")
    @ApiOperation(value = "获取所有用户")
    public List<Person> personList(){
        log.info("获取redis的数据：{}",redisUtils.get("person"));
        return personRepository.findAll();
    }

    @PostMapping(value = "/add")
    @ApiOperation(value = "添加用户")
    public Person personAdd(@RequestBody Person person){
        log.info("添加用户的参数：{}",person);
        redisUtils.set("person",person);
        return personRepository.save(person);
    }

    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "查询用户")
    public Person personFindOne(@PathVariable("id") Integer id){
        log.info("查询用户参数id：{}",id);
        return personRepository.findOne(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "删除用户")
    public void personDelete(@PathVariable("id") Integer id){
        log.info("删除用户参数id：{}",id);
        personRepository.delete(id);
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "更新用户")
    public Person personUpdate(@RequestBody Person person){
        log.info("更新用户参数：{}",person);
        return personRepository.save(person);
    }

    @GetMapping(value = "/get/age/{age}")
    @ApiOperation(value = "根据年龄查询用户")
    public List<Person> personListByAge(@PathVariable("age") Integer age){
        log.info("根据年龄查询用户参数age：{}",age);
        return personRepository.findByAge(age);
    }

    @PostMapping(value = "/two")
    @ApiOperation(value = "事务测试")
    public void insertTwo(){
        personService.insertTwo();
    }

}
