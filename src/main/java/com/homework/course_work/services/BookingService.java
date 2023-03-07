package com.homework.course_work.services;

import java.time.LocalDate;

public interface BookingService {
    void booking(String bookCode, String libraryCardNumber, LocalDate date);

    void unbooking(String bookCode, String libraryCardNumber, LocalDate date);
}
