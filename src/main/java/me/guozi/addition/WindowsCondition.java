package me.guozi.addition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by chenyun on 2020/4/6
 */
public class WindowsCondition implements Condition {
    /**
     * @param context 当前判断条件能使用的的上下文信息（环境）
     * @param metadata 注释信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取ioc使用的beanFactory
        final ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 获取类加载器
        final ClassLoader classLoader = context.getClassLoader();

        // 获取到bean定义的注册类
        final BeanDefinitionRegistry registry = context.getRegistry();
        final boolean personDefinition = registry.containsBeanDefinition("person");
        System.out.println("WindowsCondition.matches:personDefinition::" +personDefinition);

        // 获取当前环境信息
        final Environment environment = context.getEnvironment();
        final String osName = environment.getProperty("os.name");

        System.out.println("WindowsCondition.matches:os.name::" + osName);

        return osName.contains("Windows");
    }
}
