package com.homework.course_work.services.impl;

import com.homework.course_work.entities.Reader;
import com.homework.course_work.repo.ReaderRepository;
import com.homework.course_work.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository readerRepository;

    @Autowired
    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public Reader findReaderByFio(String fio) {
        return readerRepository.findByFio(fio);
    }

    @Override
    public List<Reader> findAllReader() {
        return readerRepository.findAll();
    }
}
