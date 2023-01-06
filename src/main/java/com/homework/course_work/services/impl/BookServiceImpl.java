package com.homework.course_work.services.impl;

import com.homework.course_work.entities.Book;
import com.homework.course_work.repo.BookRepository;
import com.homework.course_work.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        if (book != null) {
            bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Указан некорректный аргумент");
        }
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findBookByBookCode(String bookCode) {
        return bookRepository.findByBookCode(Integer.parseInt(bookCode));
    }

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }
}
