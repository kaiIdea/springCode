package com.codeTest.springcode.annation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Auther: YangKai
 * @Date: 2022/7/12 12:54
 * @Description:
 */
public class Test1 {

//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        User user = (User) context.getBean("user");
//        System.out.println(user);
//    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        //User user = (User) context.getBean("user");
        //User user1 = (User) context.getBean("user");
        String[] names = context.getBeanDefinitionNames();
        Map<String, User> beans = context.getBeansOfType(User.class);
        System.out.println(beans);
        //MainConfig config = (MainConfig) context.getBean("mainConfig");
        //String[] strings = context.getBeanNamesForType(User.class);
        System.out.println();
    }
}
