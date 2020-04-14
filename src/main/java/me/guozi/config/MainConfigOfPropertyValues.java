package me.guozi.config;

import me.guozi.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 演示@Value和@PropertySource注解
 * <p>
 * 1. @Value：
 * a. 基本数值；
 * b. 可以写SpEL #{};
 * c. 可以写${}，取出配置文件【properties】中的值（在运行环境变量里面的值）<br>
 * 2. @PropertySource(或者@PropertySources)：读取外部配置文件中的k/v保存到运行的环境变量中，
 * 加载完外部的配置文件以后使用${}取出配置文件的值
 * <p>
 * Created by chenyun on 2020/4/9
 */
@PropertySource("classpath:person.properties")
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }
}
