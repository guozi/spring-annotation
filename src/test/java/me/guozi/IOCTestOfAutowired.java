package me.guozi;

import me.guozi.bean.Boss;
import me.guozi.config.MainConifgOfAutowired;
import me.guozi.dao.BookDao;
import me.guozi.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by chenyun on 2020/4/9
 */
public class IOCTestOfAutowired {

    final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConifgOfAutowired.class);

    @Test
    public void test() {

        printBeanName(context);

        final BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService);

        final BookDao bookDao = context.getBean(BookDao.class);
        System.out.println(bookDao);

        final Boss boss = context.getBean(Boss.class);
        System.out.println(boss);

    }

    private void printBeanName(ApplicationContext applicationContext) {
        final String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("Bean name: " + name);
        }
    }
}
