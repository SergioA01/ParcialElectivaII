package com.example.training.repositories;

import com.example.training.entities.Costumer;
import com.example.training.entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
}
