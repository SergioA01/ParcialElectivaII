package com.example.training.repositories;

import com.example.training.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
