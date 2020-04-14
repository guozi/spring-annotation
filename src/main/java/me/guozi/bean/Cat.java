package me.guozi.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by chenyun on 2020/4/8
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("Cat.constructor...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat.afterPropertiesSet...");

    }

    public void destroy() throws Exception {
        System.out.println("Cat.destroy...");
    }
}
