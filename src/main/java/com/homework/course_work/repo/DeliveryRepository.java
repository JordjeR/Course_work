package com.homework.course_work.repo;

import com.homework.course_work.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    Delivery findDeliveriesByIssueCode(Integer issueCode);
}
