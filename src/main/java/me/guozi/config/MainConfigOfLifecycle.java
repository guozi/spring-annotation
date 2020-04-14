package me.guozi.config;

import me.guozi.bean.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean的声明周期：bean的创建->初始化->销毁的过程。
 * <p>
 * 我们可以自定义初始化和销毁方法，容器在执行到当前生命周期时调用自定义的初始化和销毁方法。
 * <p>
 * 构造（创建对象）：单实例bean在容器启动的时候创建对象；多实例bean在每次获取的时候创建对象。
 * 初始化：对象创建完成，并赋值完成，调用初始化方法。
 * 销毁：单实例bean在容器关闭的时候调用销毁方法；多实例bean容器不会管理这个bean，容器在关闭时不会调用销毁方法。
 * <p>
 * 1. 通过@Bean注解指定初始化和销毁方法：init-method和destroy-method <br>
 * 2. 通过实现InitializingBean(定义初始化方法)和DisposableBean(定义销毁方法)接口来实现 <br>
 * 3. 可以使用JSR250的@PostConstruct和@PreDestroy注解标注在要初始化方法和要销毁方法上实现 <br>
 * 4. 使用bean的后置处理器BeanPostProcessor在bean初始化前后进行一些处理工作。postProcessBeforeInitialization在初始化之前调用，
 * postProcessAfterInitialization在初始化之后调用。
 * <p>
 * Spring底层对 BeanPostProcessor 的使用：bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Async,xxx BeanPostProcessor。
 * <p>
 * Created by chenyun on 2020/4/8
 */
@Configuration
@ComponentScan("me.guozi.bean")
public class MainConfigOfLifecycle {

    //    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Book book() {
        return new Book();
    }

}
