package me.guozi;

import me.guozi.bean.Person;
import me.guozi.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by chenyun on 2020/4/9
 */
public class IOCTestOfPropertyValue {

    final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test() {

        printBeanName(context);

        System.out.println("============");

        final Person person = (Person) context.getBean("person");

        System.out.println("Person==>" + person);

    }

    private void printBeanName(ApplicationContext applicationContext) {
        final String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("Bean name: " + name);
        }
    }
}
