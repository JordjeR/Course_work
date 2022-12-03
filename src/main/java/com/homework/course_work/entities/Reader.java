package com.homework.course_work.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer libraryCardNumber;

    private String fio;
    private String address;
    private Integer phoneNumber;

    @OneToMany(mappedBy = "reader")
    private List<Booking> booking;

    @OneToMany(mappedBy = "reader")
    private List<LoanOfBooks> loanOfBooks;

    public Reader() {
    }

    public Reader(String fio, String address, Integer phoneNumber) {
        this.fio = fio;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(Integer libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public List<LoanOfBooks> getLoanOfBooks() {
        return loanOfBooks;
    }

    public void setLoanOfBooks(List<LoanOfBooks> loanOfBooks) {
        this.loanOfBooks = loanOfBooks;
    }
}
