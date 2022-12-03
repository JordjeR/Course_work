package com.homework.course_work.controllers;

import com.homework.course_work.entities.Reader;
import com.homework.course_work.repo.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReaderController {

    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderController(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @GetMapping("/readers")
    public String readers(Model model) {

        List<Reader> readers = readerRepository.findAll();

        model.addAttribute("readers", readers);

        return "readers-page";
    }

    @GetMapping("/add-reader")
    public String addReadersGet() {
        return "add-reader-page";
    }

    @PostMapping("/add-reader")
    public String addReaderPost(
            @RequestParam String fio,
            @RequestParam String address,
            @RequestParam Integer phoneNumber) {

        readerRepository.save(new Reader(fio, address, phoneNumber));

        return "redirect:/readers";
    }
}
