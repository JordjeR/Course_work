package com.homework.course_work.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
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

    @OneToMany(
            mappedBy = "book",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.REFRESH
    )
    private List<Booking> booking;

    @OneToMany(
            mappedBy = "book",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.REFRESH
    )
    private List<Delivery> deliveries;
}

