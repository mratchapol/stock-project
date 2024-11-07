package com.ratchapol.stock_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private long id;
    private String name;
    private String image;
    private int price;
    private int stock;

    public Product(long id, String name, String image, int price, int stock) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.stock = stock;
    }
}