package com.example.training.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long valor;

    @Column(nullable = false)
    private Integer Stock;

    @ManyToMany
    @JoinTable(
            name = "product_sale",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "sale_id"))
    private List<Sales> sales;

    public Product() {
    }

    public Product(Integer id, String name, Long valor, Integer stock) {
        this.id = id;
        this.name = name;
        this.valor = valor;
        Stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }

   /* public void setSales(Sales sales) {

        this.sales = sales;
    }*/
}
