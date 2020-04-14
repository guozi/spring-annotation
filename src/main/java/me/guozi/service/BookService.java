package me.guozi.service;

import me.guozi.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by chenyun on 2020/4/6
 */
@Service
public class BookService {

    @Qualifier("bookDao")
    @Autowired(required = false)
    //@Resource(name = "bookDao2")
    //@Inject
    private BookDao bookDao;

    public void print() {
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
               "bookDao=" + bookDao +
               '}';
    }
}
