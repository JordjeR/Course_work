package com.homework.course_work.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanOfBooks extends JpaRepository<LoanOfBooks, Integer> {

}
