package com.homework.course_work.services;

import com.homework.course_work.entities.Book;

import java.util.List;

public interface BookService {
    void save(Book book);

    void delete(int id);

    Book findBookByBookCode(String bookCode);

    List<Book> findAllBook();
}
