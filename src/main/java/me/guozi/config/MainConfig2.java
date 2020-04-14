package me.guozi.config;

import me.guozi.addition.CarFactoryBean;
import me.guozi.bean.Color;
import me.guozi.bean.Person;
import me.guozi.addition.MacCondition;
import me.guozi.addition.MyImportBeanDefinitionRegistrar;
import me.guozi.addition.MyImportSelector;
import me.guozi.addition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * 测试@Scope、@Lazy、@Conditional、@Import等注解
 * <p>
 * Created by chenyun on 2020/4/6
 */
@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {


    /**
     * <p>
     * {@code @Scope}: bean的作用范围，默认是单实例的。
     * <br>
     * singleton：单实例，ioc容器启动会调用方法创建对象放到ioc容器中，以后每次获取都是在容器中获取对象 <br>
     * prototype：多实例，ioc容器启动时并不会调用方法创建对象放在容器中，而是在后面每次获取的时候会调用方法创建对象 <br>
     * request：同一个请求创建一个实例 <br>
     * session：同一个session创建一个实例
     * </p>
     *
     * <p>
     * {@code @Lazy}: 懒加载。单实例的bean，默认在容器启动时会创建对象，懒加载，容器在启动时不会创建对象，
     * 而是在第一次调用（获取）Bean的时候会创建。
     * <br>
     * 与@Bean放在一起，用于延迟方法调用 <br>
     * 与@Configuration放在一起，影响类中所有@Bean的方法 <br>
     * 与@Component放在一起，这个bean将会懒初始化 <br>
     * 与@Autowired放在一起，将懒加载依赖项
     * </p>
     */
    @Scope
    @Lazy
    @Bean
    public Person person() {
        System.out.println("call person...");
        return new Person("wangwu", 30);
    }

    /**
     * {@code @Conditional}: 条件注解，满足指定条件给容器中注册bean。
     *
     * @return
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Conditional(MacCondition.class)
    @Bean("steven")
    public Person person02() {
        return new Person("Steven", 55);
    }

    /**
     * 给容器注解bean的几种方式：
     * 1. 包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）,导入自己写的组件
     * 2. @Bean，导入第三方包里的组件
     * 3. @Import，快速给容器导入一个组件
     * a. @Import(要导入到容器中的组件)，容器中就会自动注册这个组件，id默认是全类名
     * b. ImportSelector，返回要导入的组件的全类名数组
     * c. ImportBeanDefinitionRegistrar，手动注册bean到容器中
     * 4. 使用Spring提供的FactoryBean(工厂Bean)，向容器中注册两个Bean，一个是它本身，
     * 一个是FactoryBean.getObject()方法返回值所代表的Bean。通过beanName获取bean时，实际调用的是getObject()方法返回的对象，
     * 如果我们想通过beanName去获取CarFactoryBean的单例对象，需要在beanName前面添加一个&符号
     */
    @Bean
    public CarFactoryBean carFactoryBean() {
        return new CarFactoryBean();
    }
}
