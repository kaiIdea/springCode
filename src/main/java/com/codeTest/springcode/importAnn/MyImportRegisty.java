package com.codeTest.springcode.importAnn;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Auther: YangKai
 * @Date: 2022/7/12 21:12
 * @Description:
 */
public class MyImportRegisty implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //判断red and blue对象是否被加载，如果被加载，则加载Green对象

        //@import的方式导入，默认类的全限定名为Bean的id
        boolean red = registry.containsBeanDefinition("Red");
        boolean blue = registry.containsBeanDefinition("Blue");
        //所以这里永远不会进这个条件分支
        if(red && blue){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition("com.codeTest.springcode.importAnn.Green");
            registry.registerBeanDefinition("green",rootBeanDefinition);
        }
    }
}
