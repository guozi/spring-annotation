package me.guozi;

import me.guozi.bean.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenyun on 2020/4/8
 */
public class IOCTestWithXml {

    @Test
    public void test() {
        final ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        final Person bean = classPathXmlApplicationContext.getBean(Person.class);
        System.out.println(bean);
    }
}
