package com.homework.course_work.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class DeliveryController {

    @PostMapping("/delivery/{bookCode}")
    public String deliveryForReader(@PathVariable String bookCode,
                                    @RequestParam String libraryCardNumber,
                                    @RequestParam LocalDate date) {

        return "booking";
    }
}
