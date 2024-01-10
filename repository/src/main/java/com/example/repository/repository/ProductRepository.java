package com.example.repository.repository;

import com.example.repository.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<product, String> {
    product findByType(String type);
}
