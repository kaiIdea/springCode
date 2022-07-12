package com.codeTest.springcode.importAnn;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

import java.util.Set;

/**
 * @Auther: YangKai
 * @Date: 2022/7/12 21:05
 * @Description:
 */
public class MyImportSelector implements ImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //AnnotationMetadata 类的注解信息

        //获取类的注解信息或者类的注解类型
        Set<String> types = importingClassMetadata.getAnnotationTypes();

        Set<MethodMetadata> methods = importingClassMetadata.getAnnotatedMethods("Bean");
        System.out.println();
        return new String[]{"com.codeTest.springcode.importAnn.Yellow"};
    }
}
