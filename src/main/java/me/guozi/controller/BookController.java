package me.guozi.controller;

import me.guozi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by chenyun on 2020/4/6
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
