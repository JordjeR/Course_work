package com.homework.course_work.services.impl;

import com.homework.course_work.entities.Book;
import com.homework.course_work.entities.Booking;
import com.homework.course_work.entities.Reader;
import com.homework.course_work.repo.BookingRepository;
import com.homework.course_work.services.BookService;
import com.homework.course_work.services.BookingService;
import com.homework.course_work.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final ReaderService readerService;

    private final BookService bookService;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository,
                              ReaderService readerService,
                              BookService bookService
    ) {
        this.bookingRepository = bookingRepository;
        this.readerService = readerService;
        this.bookService = bookService;
    }

    @Override
    public void booking(String bookCode, String libraryCardNumber, LocalDate date) {
        Reader reader = readerService.findReaderByLibraryCardNumber(libraryCardNumber);
        Book book = bookService.findBookByBookCode(bookCode);

        Booking booking = new Booking();

        book.setNumberOfCopies(book.getNumberOfCopies() - 1);

        booking.setBook(book);
        booking.setBookCode(book.getBookCode());
        booking.setReader(reader);
        booking.setOrderDate(date);
        booking.setLibraryCardNumber(reader.getLibraryCardNumber());

        bookingRepository.save(booking);
    }

    @Override
    public void unbooking(Integer bookCode) {
//        Book book = bookService.findBookByBookCode(bookCode);
//
//        Booking booking = bookingRepository.findByBookCode(book.getBookCode());
//
//        book.setNumberOfCopies(book.getNumberOfCopies() + 1);
//
//        bookingRepository.delete(booking);
    }

    @Override
    public List<Booking> findAllBooking() {
        return bookingRepository.findAll();
    }
}
