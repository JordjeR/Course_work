package com.homework.course_work.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/all-books")
    public String hello() {
        return "index";
    }
}
