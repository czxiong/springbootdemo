package com.demo.springbootdemo.service;

import com.demo.springbootdemo.entity.Person;
import com.demo.springbootdemo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class PersonService {

    @Resource
    private PersonRepository personRepository;

    /**
     * 事务管理测试
     * 两条数据同时成功，或者同时不成功
     * 保证数据库数据的完整性和一致性
     */
    @Transactional
    public void insertTwo(){
        Person personA = new Person();
        personA.setName("秋雅");
        personA.setAge(19);
        personRepository.save(personA);

        System.out.print(1/0);

        Person personB = new Person();
        personB.setName("梦特娇");
        personB.setAge(25);
        personRepository.save(personB);
    }

}
