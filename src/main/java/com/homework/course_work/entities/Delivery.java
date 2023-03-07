package com.homework.course_work.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueCode;
    private Integer bookCode;
    private Integer libraryCardNumber;
    private LocalDate dateOfIssue;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.REFRESH
    )
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.REFRESH
    )
    @JoinColumn(name = "reader_id")
    private Reader reader;
}
