package com.ratchapol.stock_project.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int id){
        super("Could not find product of id: " + id);
    }
}