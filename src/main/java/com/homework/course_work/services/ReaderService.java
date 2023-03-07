package com.homework.course_work.services;

import com.homework.course_work.entities.Reader;

import java.util.List;

public interface ReaderService {
    Reader findReaderByLibraryCardNumber(String libraryCardNumber);

    List<Reader> findAllReader();
}
