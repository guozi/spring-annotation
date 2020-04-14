package me.guozi;

import me.guozi.bean.Person;
import me.guozi.config.MainConfig;
import me.guozi.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * Created by chenyun on 2020/4/6
 */
public class IOCTestWithAnnotation {

    final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test04() {
        printBeanName(context);

        final Object bean = context.getBean("carFactoryBean");
        System.out.println(bean.getClass());

        final Object factoryBean = context.getBean("&carFactoryBean");
        System.out.println(factoryBean.getClass());
    }

    private void printBeanName(ApplicationContext applicationContext) {
        final String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("Bean name: " + name);
        }
    }

    @Test
    public void test03() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        final String[] namesForType = context.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }

        final Map<String, Person> personMap = context.getBeansOfType(Person.class);
        System.out.println(personMap);

    }

    @Test
    public void test02() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        final String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        final Person bean = context.getBean(Person.class);
        final Person bean1 = context.getBean(Person.class);

        System.out.println(bean == bean1);
    }

    @Test
    public void test01() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        final String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        final Person person = context.getBean(Person.class);
        System.out.println(person);

        final String[] personNames = context.getBeanNamesForType(Person.class);
        for (String name : personNames) {
            System.out.println(name);
        }
    }
}
