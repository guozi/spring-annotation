package me.guozi;

import me.guozi.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by chenyun on 2020/4/12
 */
public class IOCTestOfExt {

    @Test
    public void test() {

        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);


        context.close();
    }

}
