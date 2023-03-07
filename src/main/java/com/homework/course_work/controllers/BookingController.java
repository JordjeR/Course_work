package com.homework.course_work.controllers;

import com.homework.course_work.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/booking/{bookCode}")
    public String booking(@PathVariable String bookCode,
                          @RequestParam String libraryCardNumber,
                          @RequestParam LocalDate date) {
        bookingService.booking(bookCode, libraryCardNumber, date);

        return "redirect:/book-info/{bookCode}";
    }

    @PostMapping("/unbooking/{bookCode}/{reader}/{orderDate}")
    public String unbookingFromTable(@PathVariable String bookCode,
                                     @PathVariable String reader,
                                     @PathVariable LocalDate orderDate) {
        bookingService.unbooking(bookCode, reader, orderDate);

        return "redirect:/book-info/{bookCode}";
    }
}
