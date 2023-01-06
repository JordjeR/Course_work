package com.homework.course_work.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookCode;

    private String title;
    private String author;
    private LocalDate release;
    private String publisher;
    private Integer numberOfCopies;
    private Double price;
    private Integer volume;
    private String fileName;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "book_id", referencedColumnName = "bookCode")
    @OneToMany(mappedBy = "book")
    private List<Booking> booking;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "book_id", referencedColumnName = "bookCode")
    @OneToMany(mappedBy = "book")
    private List<Delivery> deliveries;

    public Book() {
    }

    public Book(String title, String author, LocalDate release, String publisher, Integer numberOfCopies, Double price, Integer volume, String fileName) {
        this.title = title;
        this.author = author;
        this.release = release;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.price = price;
        this.volume = volume;
        this.fileName = fileName;
    }

    public Integer getBookCode() {
        return bookCode;
    }

    public void setBookCode(Integer bookCode) {
        this.bookCode = bookCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        if (release.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Дата релиза не может быть позже текущей.");
        }

        this.release = release;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        if (numberOfCopies < 0) {
            throw new IllegalArgumentException("Указано отрицательное количество экземпляров книг!");
        }

        this.numberOfCopies = numberOfCopies;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price <= 0.) {
            throw new IllegalArgumentException("Указана отрицательная цена.");
        }

        this.price = price;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        if (volume <= 0.) {
            throw new IllegalArgumentException("Указано отрицательное число кол-ва страниц.");
        }

        this.volume = volume;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Некорректно указано бронирование.");
        }

        this.booking = booking;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        if (deliveries == null) {
            throw new IllegalArgumentException("Некорректно указана выдача книг");
        }

        this.deliveries = deliveries;
    }
}

