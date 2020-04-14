package me.guozi.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by chenyun on 2020/4/8
 */
@Component
public class Dog {

    public Dog() {
        System.out.println("Dog.constructor...");
    }

    @PostConstruct
    public void init() {
        System.out.println("Dog.init...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Dog.destroy...");
    }
}
