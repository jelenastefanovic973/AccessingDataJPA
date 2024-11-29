package com.example.acessingdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity - annotation @Table doesn't exist, but it's assumed that there exists a Customer table
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) // id is generated automatically
    private Long id;
    private String firstName;
    private String lastName;

    protected Customer() {} // not used directly

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}