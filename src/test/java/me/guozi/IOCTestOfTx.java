package me.guozi;

import me.guozi.tx.TxConfig;
import me.guozi.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by chenyun on 2020/4/9
 */
public class IOCTestOfTx {

    @Test
    public void test() {

        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

        final UserService userService = context.getBean(UserService.class);

        userService.insertUser();
    }

}
