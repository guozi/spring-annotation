package me.guozi.addition;

import me.guozi.bean.Sun;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * Created by chenyun on 2020/4/7
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata 当前标准@Import注解类的所有注解信息
     * @param registry BeanDefinition注册类，把所有需要添加到容器的bean通过掉用{@link BeanDefinitionRegistry#registerBeanDefinition}
     * 方法手工注册进来。
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        final Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();

        System.out.println("MyImportBeanDefinitionRegistrar.registerBeanDefinitions:annotationTypes::" + annotationTypes);

        final String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("MyImportBeanDefinitionRegistrar.registerBeanDefinitions:beanDefinitionName::" + beanDefinitionName);
        }

        final boolean weather = registry.containsBeanDefinition("me.guozi.bean.Weather");
        if (weather) {
            final RootBeanDefinition beanDefinition = new RootBeanDefinition(Sun.class);
            registry.registerBeanDefinition("sun", beanDefinition);
        }


    }
}
