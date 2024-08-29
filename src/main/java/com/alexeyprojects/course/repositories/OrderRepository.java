package com.alexeyprojects.course.repositories;

import com.alexeyprojects.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
