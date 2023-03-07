package com.homework.course_work.services.impl;

import com.homework.course_work.entities.Reader;
import com.homework.course_work.repo.ReaderRepository;
import com.homework.course_work.services.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository readerRepository;

    @Override
    @Transactional(readOnly = true)
    public Reader findReaderByLibraryCardNumber(String libraryCardNumber) {
        return readerRepository.findById(Integer.parseInt(libraryCardNumber))
                .orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reader> findAllReader() {
        return readerRepository.findAll();
    }
}
