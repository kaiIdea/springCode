package com.codeTest.springcode.annation;

import com.codeTest.springcode.condition.ManCondition;
import com.codeTest.springcode.condition.WoManCondition;
import org.springframework.context.annotation.*;

/**
 * @Auther: YangKai
 * @Date: 2022/7/12 18:58
 * @Description: 增加单例，多例判断
 */
@Configuration
public class MainConfig2{
    //关于scope的作用范围：
    //{
    //  1.singleton单例 ioc容器启动的时候会加载对象放到容器里面，获取对象直接从容器里面拿。map.get
    //  2.prototype多例 ioc容器启动不会加载对象，只会在获取时重建，且每次获取都是创建新对象
    //}
    //@Scope("prototype")
    @Lazy //懒加载，只针对单例对象，容器启动的时候不加载对象，在第一次获取的时候进行加载。且只会被加载一次
    @Bean("user")
    public User getUser(){
        System.out.println("---> 生成user对象");
        return new User(2,"boy");
    }

    //判断条件，进行加载bean
    @Conditional({ManCondition.class})
    @Bean("man")
    public User man(){
        return new User(3,"man");
    }

    /**
     * 实现Condition接口，通过实现类定制Bean加载规则。
     * @return
     */
    @Conditional({WoManCondition.class})
    @Bean("woman")
    public User woman(){
        return new User(4,"woman");
    }
}
