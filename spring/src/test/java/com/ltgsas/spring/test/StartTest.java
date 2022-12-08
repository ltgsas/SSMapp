package com.ltgsas.spring.test;

import com.ltgsas.spring.pojo.Tdbassistan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartTest {
    public static void main(String[] args) {
        ApplicationContext appcontext = new ClassPathXmlApplicationContext("firstBeans.xml");
        Tdbassistan tdbassistan = (Tdbassistan) appcontext.getBean("initialize");
        System.out.println(tdbassistan);
    }
}
