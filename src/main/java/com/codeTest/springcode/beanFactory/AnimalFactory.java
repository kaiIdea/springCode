package com.codeTest.springcode.beanFactory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Auther: YangKai
 * @Date: 2022/7/12 21:53
 * @Description:
 */
public class AnimalFactory implements FactoryBean<Animal> {
    @Override
    public Animal getObject() throws Exception {
        return new Dog();
    }
    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }
}
