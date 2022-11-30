package com.homework.course_work.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}


