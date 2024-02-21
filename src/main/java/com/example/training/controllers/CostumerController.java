package com.example.training.controllers;

import com.example.training.entities.Costumer;
import com.example.training.entities.Sales;
import com.example.training.services.CostumerService;
import com.example.training.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.training.responses.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("costumer")
public class CostumerController {
    @Autowired
    private CostumerService costumerService;
    @Autowired
    private SalesService salesService;

    @GetMapping()
    public ResponseEntity<Object> findAll(){

        try {

            List<Costumer> result = costumerService.findAll();

            return ResponseHandler.generateResponse("Success",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Costumer costumer ){
        try {
            Costumer result = costumerService.save( costumer );

            return  ResponseHandler.generateResponse("Success", HttpStatus.CREATED,result);

        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id ){
        try{
            Costumer costumer = costumerService.findById( id );
            if( costumer != null ){

                costumerService.delete( costumer );

                return ResponseHandler.generateResponse("Succes",HttpStatus.ACCEPTED, costumer );
            }

            return ResponseHandler.generateResponse("Success Author",HttpStatus.NOT_FOUND, null );

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById( @PathVariable Integer id ){
        try {
            Costumer costumer = costumerService.findById( id );

            return  ResponseHandler.generateResponse("Success",HttpStatus.OK,costumer );
        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Object> getBooks(@PathVariable Integer id){
        try{
            Costumer costumer = costumerService.findById( id );
            if( costumer != null ){

                List<Sales> result = costumerService.getSales( costumer );

                return ResponseHandler.generateResponse("Succes",HttpStatus.CREATED, result );
            }

            return ResponseHandler.generateResponse("Success Author",HttpStatus.NOT_FOUND, null );

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }
}
