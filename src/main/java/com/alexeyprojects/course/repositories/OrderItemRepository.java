package com.alexeyprojects.course.repositories;

import com.alexeyprojects.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
