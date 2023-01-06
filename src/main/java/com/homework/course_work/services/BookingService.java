package com.homework.course_work.services;

import com.homework.course_work.entities.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    void booking(String bookCode, String libraryCardNumber, LocalDate date);

    void unbooking(Integer bookCode);

    List<Booking> findAllBooking();
}
