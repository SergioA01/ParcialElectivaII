package com.example.training.services;

import com.example.training.entities.Customer;
import com.example.training.entities.Product;
import com.example.training.entities.Sale;
import com.example.training.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    public List<Sale> findAll(){

        return saleRepository.findAll();
    }


    public Sale findById(Integer id ){
        Optional<Sale> optional = saleRepository.findById( id );

        return optional.isPresent() ? optional.get() : null;
    }

    public Sale save(Sale sale, Customer customer, Product products){
        sale.setCustomer(customer);
        sale.setProducts(List.of(products));

        return saleRepository.save(sale);
    }

    public List<Product> getProducts(Sale sale){
        return sale.getProducts();
    }
    


}
