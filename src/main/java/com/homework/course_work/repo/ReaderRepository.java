package com.homework.course_work.repo;

import com.homework.course_work.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
    Reader findByFio(String fio);
}
