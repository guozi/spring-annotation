package me.guozi;

import me.guozi.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by chenyun on 2020/4/6
 */
public class IOCTestOfLifecycle {


    @Test
    public void test01() {
        System.out.println("开始创建容器");
        // 创建IOC容器
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        System.out.println("容器创建完成");

        // 容器关闭
        System.out.println("开始关闭容器");
        context.close();
        System.out.println("容器关闭完成");


    }
}
