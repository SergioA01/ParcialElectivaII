package com.example.training.services;

import com.example.training.entities.Costumer;
import com.example.training.entities.Product;
import com.example.training.entities.Sales;
import com.example.training.repositories.CostumerRepository;
import com.example.training.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {
    @Autowired
    SalesRepository salesRepository;

    public List<Sales> findAll(){

        return salesRepository.findAll();
    }


    public Sales findById( Integer id ){
        Optional<Sales> optional = salesRepository.findById( id );

        return optional.isPresent() ? optional.get() : null;
    }

    public Sales save(Sales sales, Costumer costumer){
        sales.setCostumer( costumer );

        return salesRepository.save( sales );
    }

    /*public List<Product> getProducts(Product product ){
        return product.getProducts();
    }*/


}
