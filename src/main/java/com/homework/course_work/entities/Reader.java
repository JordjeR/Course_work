package com.homework.course_work.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "reader")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer libraryCardNumber;
    private String fio;
    private String address;
    private Integer phoneNumber;

    @OneToMany(
            mappedBy = "reader",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.REFRESH
    )
    private List<Booking> booking;

    @OneToMany(
            mappedBy = "reader",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.REFRESH
    )
    private List<Delivery> deliveries;
}
