package com.homework.course_work.services;

import com.homework.course_work.entities.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    void bookingForReader(String readerFio, LocalDate dateBooking, Integer bookCode);

    void unbookingForReader(Integer bookCode);

    List<Booking> findAllBooking();
}
