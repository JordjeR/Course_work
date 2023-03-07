package com.homework.course_work.services;

import java.time.LocalDate;

public interface DeliveryService {
    void delivery(String bookCode, String libraryCardNumber, LocalDate date, boolean isNotBooking);

    void returnBook(String bookCode, String issueCode);
}
