package com.homework.course_work.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer libraryCardNumber;

    private String fio;
    private String address;
    private Integer number;

    @OneToMany(mappedBy = "reader")
    private List<Booking> booking;

    @OneToMany(mappedBy = "reader")
    private List<LoanOfBooks> loanOfBooks;
}
