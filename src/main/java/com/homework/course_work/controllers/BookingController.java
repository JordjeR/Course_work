package com.homework.course_work.controllers;

import com.homework.course_work.entities.Book;
import com.homework.course_work.entities.Booking;
import com.homework.course_work.entities.Reader;
import com.homework.course_work.services.BookService;
import com.homework.course_work.services.BookingService;
import com.homework.course_work.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final BookService bookService;
    private final ReaderService readerService;

    @Autowired
    public BookingController(BookingService bookingService,
                             BookService bookService,
                             ReaderService readerService) {
        this.bookingService = bookingService;
        this.bookService = bookService;
        this.readerService = readerService;
    }

    //TODO убрать метод
    @GetMapping("/booking/{bookCode}")
    public String bookInfoById(@PathVariable String bookCode,
                               @ModelAttribute Reader reader,
                               Model model) {
        Book book = bookService.findBookByBookCode(bookCode);
        List<Reader> readers = readerService.findAllReader();
        List<Booking> bookings = bookingService.findAllBooking();

        model.addAttribute("book", book);
        model.addAttribute("readers", readers);
        model.addAttribute("bookings", bookings);

        return "booking";
    }

    @PostMapping("/booking/{bookCode}")
    public String booking(@PathVariable String bookCode,
                          @RequestParam String libraryCardNumber,
                          @RequestParam LocalDate date) {
        bookingService.booking(bookCode, libraryCardNumber, date);

        return "redirect:/book-info/{bookCode}";
    }

    @PostMapping("/unbooking")
    public String unbookingForReader(
            @RequestParam String reader,
            @RequestParam LocalDate bookingDate,
            @RequestParam Integer bookCode) {
        return "booking";
    }
}
