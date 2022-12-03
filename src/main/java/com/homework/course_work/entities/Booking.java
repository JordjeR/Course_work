package com.homework.course_work.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingСode;

    private Integer bookCode;
    private Integer libraryCardNumber;
    private LocalDate orderDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", foreignKey = @ForeignKey(name = "FK_BOOK_ID"))
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reader_id", foreignKey = @ForeignKey(name = "FK_READER_ID"))
    private Reader reader;

    public Booking() {
    }

    public Booking(Integer bookCode, Integer libraryCardNumber, LocalDate orderDate) {
        this.bookCode = bookCode;
        this.libraryCardNumber = libraryCardNumber;
        this.orderDate = orderDate;
    }

    public Integer getBookingСode() {
        return bookingСode;
    }

    public Integer getBookCode() {
        return bookCode;
    }

    public void setBookCode(Integer bookCode) {
        this.bookCode = bookCode;
    }

    public Integer getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(Integer libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}


