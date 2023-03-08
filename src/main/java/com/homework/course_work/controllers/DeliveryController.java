package com.homework.course_work.controllers;

import com.homework.course_work.services.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/delivery/{bookCode}/{reader}/{bookingСode}")
    public String deliveryFromTable(@PathVariable String bookCode,
                                    @PathVariable String reader,
                                    @PathVariable String bookingСode) {
        deliveryService.delivery(bookCode, reader, bookingСode, false);

        return "redirect:/book-info/{bookCode}";
    }

    @PostMapping("/delivery/{bookCode}")
    public String deliveryFromButton(@PathVariable String bookCode,
                                     @RequestParam String libraryCardNumber) {
        deliveryService.delivery(bookCode, libraryCardNumber, "", true);

        return "redirect:/book-info/{bookCode}";
    }

    @PostMapping("/returnBook/{bookCode}/{issueCode}")
    public String returnBook(@PathVariable String bookCode,
                             @PathVariable String issueCode) {
        deliveryService.returnBook(bookCode, issueCode);

        return "redirect:/book-info/{bookCode}";
    }
}