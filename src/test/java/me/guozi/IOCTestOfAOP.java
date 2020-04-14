package me.guozi;

import me.guozi.aop.MathCalculator;
import me.guozi.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by chenyun on 2020/4/9
 */
public class IOCTestOfAOP {

    @Test
    public void test() {

        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        final MathCalculator calculator = context.getBean(MathCalculator.class);
        final int value = calculator.div(6, 3);

        System.out.println("返回值：" + value);
    }

}
