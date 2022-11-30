package com.homework.course_work.services;

import com.homework.course_work.entities.Book;

public interface BookService {
    void save(Book book);

    void delete(int id);

    Book findBookById(int id);
}
