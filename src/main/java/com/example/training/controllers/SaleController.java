package com.example.training.controllers;

import com.example.training.entities.Customer;
import com.example.training.entities.Product;
import com.example.training.entities.Sale;
import com.example.training.responses.ResponseHandler;
import com.example.training.services.CustomerService;
import com.example.training.services.ProductService;
import com.example.training.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try{
            List<Sale> result = saleService.findAll();

            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result );

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PostMapping("/{id}/{idProduct}")
    public ResponseEntity<Object> save(@RequestBody Sale sale, @PathVariable Integer id, @PathVariable Integer idProduct ){
        try{
            Product product = productService.getProductById(idProduct);
            Customer customer = customerService.findById( id );
            if( (customer != null) && (product != null) ){

                Sale result = saleService.save(sale, customer, product );

                return ResponseHandler.generateResponse("Succes",HttpStatus.CREATED, result );
            }
            return ResponseHandler.generateResponse("Success Author",HttpStatus.NOT_FOUND, null );

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProducts(@PathVariable Integer id){
        try{
            Sale sale = saleService.findById( id );
            if( sale != null ){

                List<Product> result = saleService.getProducts(sale);

                return ResponseHandler.generateResponse("Succes",HttpStatus.CREATED, result );
            }

            return ResponseHandler.generateResponse("Success Author",HttpStatus.NOT_FOUND, null );

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }


}
