package com.example.training.controllers;

import com.example.training.entities.Costumer;
import com.example.training.entities.Product;
import com.example.training.entities.Sales;
import com.example.training.responses.ResponseHandler;
import com.example.training.services.CostumerService;
import com.example.training.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SalesController {
    @Autowired
    private SalesService salesService;
    @Autowired
    private CostumerService costumerService;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try{
            List<Sales> result = salesService.findAll();

            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result );

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save(@RequestBody Sales sales, @PathVariable Integer id ){
        try{
            Costumer costumer = costumerService.findById( id );
            if( costumer != null ){

                Sales result = salesService.save( sales, costumer );

                return ResponseHandler.generateResponse("Succes",HttpStatus.CREATED, sales   );
            }
            return ResponseHandler.generateResponse("Success Author",HttpStatus.NOT_FOUND, null );

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    /*@GetMapping("/product/{id}")
    public ResponseEntity<Object> getBooks(@PathVariable Integer id){
        try{
            Sales sales = salesService.findById( id );
            if( sales != null ){

                List<Product> result = salesService.getProducts( sales );

                return ResponseHandler.generateResponse("Succes",HttpStatus.CREATED, result );
            }

            return ResponseHandler.generateResponse("Success Author",HttpStatus.NOT_FOUND, null );

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }*/

}
