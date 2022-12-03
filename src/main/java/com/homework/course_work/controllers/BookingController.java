package com.homework.course_work.controllers;

import com.homework.course_work.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public String bookingForReader(
            @RequestParam String reader,
            @RequestParam LocalDate bookingDate,
            @RequestParam Integer bookCode) {

        bookingService.bookingForReader(reader, bookingDate, bookCode);

        return "redirect:/library";
    }
}
