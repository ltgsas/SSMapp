package com.ltgsas.spring.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
@Data
public class People {
    @Resource
    private Cat cat;
    @Autowired
    private Dog dog;
    private String name;

}
