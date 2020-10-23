package com.my.test.myproject.spring;

import com.my.test.myproject.MyprojectApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: Ruixiao.Xu
 * @Date: 23/10/20 2:34 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyprojectApplication.class)
public class SpringTest {

    @Autowired
    ShitService shitService;

    @Test
    public void test(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        ShitService someBean= (ShitService) context.getBean("someBean");
        shitService.produceShit();
    }




}
