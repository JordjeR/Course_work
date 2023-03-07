package com.homework.course_work.services.impl;

import com.homework.course_work.entities.Book;
import com.homework.course_work.repo.BookRepository;
import com.homework.course_work.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional
    public void save(Book book) {
        if (book != null) {
            bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Указан некорректный аргумент");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Book findBookByBookCode(String bookCode) {
        return bookRepository.findByBookCode(Integer.parseInt(bookCode));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }
}
