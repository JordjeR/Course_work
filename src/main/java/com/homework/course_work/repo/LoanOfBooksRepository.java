package com.homework.course_work.repo;

import com.homework.course_work.entities.LoanOfBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanOfBooksRepository extends JpaRepository<LoanOfBooks, Integer> {

}
