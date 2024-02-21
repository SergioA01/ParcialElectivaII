package com.example.training.repositories;

import com.example.training.entities.Costumer;
import com.example.training.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
