package com.homework.course_work.service;

import com.homework.course_work.entities.Book;
import com.homework.course_work.service.commonConfig.CommonConfigJPATest;
import com.homework.course_work.services.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class DataBaseTest extends CommonConfigJPATest {

    @Autowired
    private BookService bookService;

    @Test
    void testDb() {
        List<Book> all = bookService.findAllBook();
        Assertions.assertEquals(3, all.size(), "Что то пошло не так.");
    }
}
