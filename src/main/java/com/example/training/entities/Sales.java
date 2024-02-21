package com.example.training.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Long valorTotal;

    @ManyToMany(mappedBy = "sales")
    @JsonIgnore
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_sales_to_costumer"))
    @JsonIgnore
    private Costumer costumer;


    public Sales() {
    }

    public Sales(Integer id, LocalDate fecha, Long valorTotal) {
        this.id = id;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setCostumer(Costumer costumer) {

        this.costumer = costumer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
