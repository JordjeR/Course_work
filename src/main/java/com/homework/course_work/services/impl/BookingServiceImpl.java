package com.homework.course_work.services.impl;

import com.homework.course_work.entities.Book;
import com.homework.course_work.entities.Booking;
import com.homework.course_work.entities.Reader;
import com.homework.course_work.repo.BookingRepository;
import com.homework.course_work.services.BookService;
import com.homework.course_work.services.BookingService;
import com.homework.course_work.services.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ReaderService readerService;
    private final BookService bookService;

    @Override
    @Transactional
    public void booking(String bookCode, String libraryCardNumber, LocalDate date) {
        Reader reader = readerService.findReaderByLibraryCardNumber(libraryCardNumber);
        Book book = bookService.findBookByBookCode(bookCode);

        book.setNumberOfCopies(book.getNumberOfCopies() - 1);

        Booking booking = new Booking();
        booking.setBook(book);
        booking.setBookCode(book.getBookCode());
        booking.setReader(reader);
        booking.setOrderDate(date);
        booking.setLibraryCardNumber(reader.getLibraryCardNumber());

        bookingRepository.save(booking);
    }

    @Override
    @Transactional
    public void unbooking(String bookCode, String libraryCardNumber, LocalDate date) {
        Book book = bookService.findBookByBookCode(bookCode);
        Reader reader = readerService.findReaderByLibraryCardNumber(libraryCardNumber);

        Booking booking = book.getBooking().stream()
                .filter(b -> b.getReader().getFio().equals(reader.getFio()))
                .filter(b -> b.getOrderDate().isEqual(date))
                .findFirst()
                .get();

        bookingRepository.delete(booking);

        book.setNumberOfCopies(book.getNumberOfCopies() + 1);
        bookService.save(book);
    }
}
