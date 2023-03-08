package com.homework.course_work.services;

import com.homework.course_work.entities.Booking;

import java.time.LocalDate;

public interface BookingService {
    void booking(String bookCode, String libraryCardNumber, LocalDate date);

    void unbooking(String bookCode, String bookingCode);
}
