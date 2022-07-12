package com.codeTest.springcode.annation;

import com.codeTest.springcode.beanFactory.AnimalFactory;
import com.codeTest.springcode.importAnn.Blue;
import com.codeTest.springcode.importAnn.MyImportRegisty;
import com.codeTest.springcode.importAnn.MyImportSelector;
import com.codeTest.springcode.importAnn.Red;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Map;

/**
 * @Auther: YangKai
 * @Date: 2022/7/12 20:57
 * @Description: 本配置 主要使用import类的注解
 * {
 *     1.@import 一般导入。支持多个类。
 *     2.importSelector 组件导入选择器。支持业务筛选然后进行导入,返回需要导入的类的全限定名数组。
 *       如：com.codeTest.springcode.importAnn.Yellow，默认以类的全限定名为Bean的id
 *     3.ImportBeanDefinitionRegistrar 通过添加BeanDefinition的方式进行导入。
 *       需要子类实现ImportBeanDefinitionRegistrar方法，重写registry方法
 * }
 */
@Configuration
@Import({Red.class, Blue.class, MyImportSelector.class, MyImportRegisty.class})
public class MainConfig3 {



    @Bean
    public AnimalFactory animalFactory(){
        return new AnimalFactory();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println(name);
        }

        Object animalFactory = context.getBean("animalFactory");
        System.out.println();
    }
}


