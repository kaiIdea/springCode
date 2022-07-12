package com.codeTest.springcode.annation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: YangKai
 * @Date: 2022/7/12 12:56
 * @Description:定义这个类为一个配置类，相当于一个xml文件
 * 接下来就可以在这个类中指定bean,等同于在xml文件中<bean id="" class=""></bean>
 *
 * ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
 * 通过这种方式进行获取，传入配置类的类型
 */
@Configuration
//@ComponentScan(value = {"com.codeTest","com.test"})
@ComponentScan(value = {"com"})
public class MainConfig1 {
    /**
     * Bean注解等同于<Bean></Bean>
     *
     * @Bean("") 给bean指定唯一的id,
     *  这种方式的话，如果不指定，则 bean id默认为方法名，beanType为方法返回类型
     * @return
     */
    @Bean("user01")
    public User getUser(){
        return new User(1,"girl");
    }
}
