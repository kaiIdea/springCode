package com.codeTest.springcode.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Auther: YangKai
 * @Date: 2022/7/12 19:37
 * @Description:
 */
public class WoManCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        BeanDefinitionRegistry contextRegistry = context.getRegistry();
        if(contextRegistry.containsBeanDefinition("man")){
            return true;
        }
        if(property.contains("linux")){
            return true;
        }
        return false;
    }
}
