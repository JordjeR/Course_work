package com.homework.course_work.services.impl;

import com.homework.course_work.entities.Book;
import com.homework.course_work.entities.Delivery;
import com.homework.course_work.entities.Reader;
import com.homework.course_work.repo.DeliveryRepository;
import com.homework.course_work.services.BookService;
import com.homework.course_work.services.BookingService;
import com.homework.course_work.services.DeliveryService;
import com.homework.course_work.services.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final BookingService bookingService;
    private final ReaderService readerService;
    private final BookService bookService;

    @Override
    @Transactional
    public void delivery(String bookCode, String libraryCardNumber, LocalDate date, boolean isNotBooking) {
        Reader reader = readerService.findReaderByLibraryCardNumber(libraryCardNumber);
        Book book = bookService.findBookByBookCode(bookCode);
        book.setNumberOfCopies(book.getNumberOfCopies() - 1);

        Delivery delivery = new Delivery();
        delivery.setBook(book);
        delivery.setBookCode(book.getBookCode());
        delivery.setLibraryCardNumber(reader.getLibraryCardNumber());
        delivery.setReader(reader);
        delivery.setDateOfIssue(date);

        deliveryRepository.save(delivery);

        if (!isNotBooking)
            bookingService.unbooking(String.valueOf(book.getBookCode()), String.valueOf(reader.getLibraryCardNumber()), date);
    }

    @Override
    @Transactional
    public void returnBook(String bookCode, String issueCode) {
        Book book = bookService.findBookByBookCode(bookCode);
        Delivery delivery = deliveryRepository.findDeliveriesByIssueCode(Integer.parseInt(issueCode));

        deliveryRepository.delete(delivery);
        book.setNumberOfCopies(book.getNumberOfCopies() + 1);
        bookService.save(book);
    }
}
