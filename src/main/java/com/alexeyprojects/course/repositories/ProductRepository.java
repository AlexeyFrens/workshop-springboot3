package com.alexeyprojects.course.repositories;

import com.alexeyprojects.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
