package com.homework.course_work.service.config;

import com.homework.course_work.repo.BookRepository;
import com.homework.course_work.services.BookService;
import com.homework.course_work.services.impl.BookServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class BookServiceConfiguration {

    @Bean
    public BookService bookService(BookRepository bookRepository) {
        return new BookServiceImpl(bookRepository);
    }
}
