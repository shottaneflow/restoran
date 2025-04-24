package org.example.kursovaya.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="menu")
public class Menu {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;


    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Product> products;



    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
