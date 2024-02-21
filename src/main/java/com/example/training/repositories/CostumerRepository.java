package com.example.training.repositories;

import com.example.training.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer, Integer> {
}
