package com.example.training.services;

import com.example.training.entities.Costumer;
import com.example.training.entities.Sales;
import com.example.training.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {
    @Autowired
    CostumerRepository costumerRepository;

    public List<Costumer> findAll(){

        return costumerRepository.findAll();
    }

    public Costumer findById( Integer id ){
        Optional<Costumer> optional = costumerRepository.findById(id);

        return optional.isPresent() ? optional.get() : null;
    }

    public Costumer save(Costumer costumer ){

        return costumerRepository.save( costumer );
    }

    public void delete( Costumer costumer ){

        costumerRepository.delete( costumer);
    }

    public List<Sales> getSales(Costumer costumer ){
        return costumer.getSales();
    }
}
