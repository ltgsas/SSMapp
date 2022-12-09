package com.ltgsas.spring.test;

import com.ltgsas.spring.pojo.People;
import com.ltgsas.spring.pojo.Tdbassistan;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartTest {
    public static void main(String[] args) {
        ApplicationContext appcontext = new ClassPathXmlApplicationContext("firstBeans.xml");
        Tdbassistan tdbassistan = appcontext.getBean("initialize", Tdbassistan.class);
        System.out.println(tdbassistan);
        System.out.println(tdbassistan.toString());
    }
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("twoBeans.xml");
        People people = context.getBean("people", People.class);
        people.getCat().shout();
        people.getDog().shout();
        System.out.println(people);

    }
}
