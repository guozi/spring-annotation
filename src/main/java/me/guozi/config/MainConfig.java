package me.guozi.config;

import me.guozi.addition.MyTypeFilter;
import me.guozi.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 测试@Configuration、@Bean、@ComponentScan注解
 * <p>
 * 1. @Configuration:告诉Spring这是一个配置类
 * 2. @ComponentScan:指定扫描的包路径，excludeFilters = @ComponentScan.Filter[] 指定扫描时排除哪些组件
 * includeFilters = @ComponentScan.Filter[] 指定扫描时只扫描哪些组件，需要搭配useDefaultFilters = false一起使用
 * <p>
 * Created by chenyun on 2020/4/6
 */
@Configuration
@ComponentScan(value = "me.guozi",
    includeFilters = {@ComponentScan.Filter(classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BookDao.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)},
    useDefaultFilters = false)
public class MainConfig {

    /**
     * 1. 给Spring容器中注入一个bean，类型为返回值的类型，id默认是用方法名称为id名称，
     * 也可以用@Bean注解的name或者value设置id名称。
     *
     * @return
     */
    @Bean("person")
    public Person person01() {
        return new Person("lisi", 25);
    }
}
