package com.example.training.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20, name = "last-name")
    private String lastName;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Long phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;


    public Customer() {

        sales = new ArrayList<>();
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }


    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
