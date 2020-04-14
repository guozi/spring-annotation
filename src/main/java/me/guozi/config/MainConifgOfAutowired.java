package me.guozi.config;

import me.guozi.bean.Boss;
import me.guozi.bean.Car;
import me.guozi.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 测试自动装配，Spring利用依赖注入（DI），完成对IOC容器中中各个组件的依赖关系赋值。
 * <p>
 * 1. @Autowired：自动注入：
 * a. 默认优先按照类型去容器中找对应的组件:applicationContext.getBean(BookDao.class)找到就赋值；
 * b. 如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找applicationContext.getBean("bookDao")；
 * c. @Qualifier("bookDao")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名；
 * d. 自动装配默认一定要将属性赋值好，没有就会报错。可以使用@Autowired(required=false);
 * e. @Primary：让Spring进行自动装配的时候，默认使用首选的bean。也可以继续使用@Qualifier指定需要装配的bean的名字。
 * <p>
 * 2.Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
 * a. @Resource:可以和@Autowired一样实现自动装配功能，默认是按照组件名称进行装配的，没有能支持@Primary功能，没有支持@Autowired（reqiured=false）；
 * b. @Inject:需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能。
 * 注：@Autowired：Spring定义的，@Resource、@Inject都是java规范。 <p>
 * 3. @Autowired:构造器，参数，方法，属性；都是从容器中获取参数组件的值。
 * a. [标注在方法位置]：@Bean+方法参数，参数从容器中获取，默认不写@Autowired效果是一样的，都能自动装配；
 * b. [标在构造器上]：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取；
 * c. 放在参数位置，public Boss boss(@Autowired Car car){}
 * <p>
 * 4. 自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）。
 * 自定义组件实现xxxAware；在创建对象的时候，会调用接口规定的方法注入相关组件；Aware；把Spring底层一些组件注入到自定义的Bean中；
 * xxxAware：功能使用xxxProcessor；ApplicationContextAware==》ApplicationContextAwareProcessor；
 * Created by chenyun on 2020/4/9
 */
@Configuration
@ComponentScan(value = {"me.guozi.dao", "me.guozi.service", "me.guozi.controller", "me.guozi.bean"})
public class MainConifgOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        final BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    /**
     * {@code @Bean}标注的方法创建对象的时候，方法参数的值从容器中获取
     *
     * @param car
     * @return
     */
    @Bean
    public Boss boss(Car car) {
        return new Boss(car);
    }
}
