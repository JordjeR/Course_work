package com.homework.course_work.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "loan_of_book")
public class LoanOfBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueCode;

    private Integer bookCode;
    private Integer libraryCardNumber;
    private LocalDate dateOfIssue;
    private LocalDate returnDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", foreignKey = @ForeignKey(name = "FK_BOOK_ID"))
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reader_id", foreignKey = @ForeignKey(name = "FK_READER_ID"))
    private Reader reader;

    public LoanOfBooks() {
    }

    public LoanOfBooks(Integer bookCode, Integer libraryCardNumber, LocalDate dateOfIssue, LocalDate returnDate) {
        this.bookCode = bookCode;
        this.libraryCardNumber = libraryCardNumber;
        this.dateOfIssue = dateOfIssue;
        this.returnDate = returnDate;
    }

    public Integer getIssueCode() {
        return issueCode;
    }

    public void setIssueCode(Integer issueCode) {
        this.issueCode = issueCode;
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

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
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
