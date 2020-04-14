package me.guozi.bean;

/**
 * Created by chenyun on 2020/4/8
 */
public class Book {

    public Book() {
        System.out.println("Book.constructor...");
    }

    public void init() {
        System.out.println("Book.init...");
    }

    public void destroy() {
        System.out.println("Book.destroy...");
    }
}
