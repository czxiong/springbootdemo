package com.demo.springbootdemo.repository;

import com.demo.springbootdemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    //自定义根据年龄查询
    List<Person> findByAge(Integer age);

}
