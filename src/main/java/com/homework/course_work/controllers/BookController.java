package com.homework.course_work.controllers;

import com.homework.course_work.entities.Book;
import com.homework.course_work.entities.Booking;
import com.homework.course_work.entities.Delivery;
import com.homework.course_work.entities.Reader;
import com.homework.course_work.services.BookService;
import com.homework.course_work.services.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    @Value("${upload.path}")
    private String pathToFile;

    private final BookService bookService;
    private final ReaderService readerService;

    @GetMapping("/library")
    public String library(Model model) {
        List<Book> books = bookService.findAllBook();
        List<Reader> readers = readerService.findAllReader();

        model.addAttribute("books", books);
        model.addAttribute("readers", readers.size());
        return "library";
    }

    @GetMapping("/book-info/{bookCode}")
    public String bookInfoByBookCode(@PathVariable String bookCode,
                                     Model model) {
        Book book = bookService.findBookByBookCode(bookCode);
        List<Reader> readers = readerService.findAllReader();
        List<Booking> bookings = book.getBooking();
        List<Delivery> deliveries = book.getDeliveries();

        model.addAttribute("book", book);
        model.addAttribute("readers", readers);
        model.addAttribute("bookings", bookings);
        model.addAttribute("deliveries", deliveries);
        return "book-info";
    }

    @GetMapping("/add-book")
    public String addBook() {
        return "add-book";
    }

    @PostMapping("/add-book")
    public String addBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam LocalDate release,
            @RequestParam String publisher,
            @RequestParam Integer numberOfCopies,
            @RequestParam Double price,
            @RequestParam Integer volume,
            @RequestParam MultipartFile file,
            Model model) throws IOException {

        Book book = new Book();

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadFile = new File(pathToFile);

            if (!uploadFile.exists()) uploadFile.mkdir();

            String uniqueNameForFile = getUniqueNameForFile(file.getOriginalFilename());

            file.transferTo(new File(pathToFile + "/" + uniqueNameForFile));

            book.setTitle(title);
            book.setAuthor(author);
            book.setRelease(release);
            book.setPublisher(publisher);
            book.setNumberOfCopies(numberOfCopies);
            book.setPrice(price);
            book.setVolume(volume);
            book.setFileName(uniqueNameForFile);
        }

        bookService.save(book);
        List<Book> books = bookService.findAllBook();

        model.addAttribute("books", books);
        return "redirect:/library";
    }

    private String getUniqueNameForFile(String fileName) {
        return "addedFile_" + LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("dd_MM_yyyy_HH-mm-ss")) + "_" + fileName;
    }
}
