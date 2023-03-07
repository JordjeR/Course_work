package com.homework.course_work.controllers;

import com.homework.course_work.services.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/delivery/{bookCode}/{reader}/{orderDate}")
    public String deliveryFromTable(@PathVariable String bookCode,
                                    @PathVariable String reader,
                                    @PathVariable LocalDate orderDate) {
        deliveryService.delivery(bookCode, reader, orderDate, false);

        return "redirect:/book-info/{bookCode}";
    }

    @PostMapping("/delivery/{bookCode}")
    public String deliveryFromButton(@PathVariable String bookCode,
                                     @RequestParam String libraryCardNumber,
                                     @RequestParam LocalDate date) {
        deliveryService.delivery(bookCode, libraryCardNumber, date, true);

        return "redirect:/book-info/{bookCode}";
    }

    @PostMapping("/returnBook/{bookCode}/{issueCode}")
    public String returnBook(@PathVariable String bookCode,
                             @PathVariable String issueCode) {
        deliveryService.returnBook(bookCode, issueCode);

        return "redirect:/book-info/{bookCode}";
    }
}