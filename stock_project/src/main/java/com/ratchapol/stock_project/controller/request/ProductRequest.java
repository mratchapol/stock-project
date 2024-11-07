package com.ratchapol.stock_project.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private MultipartFile image;
    private int price;
    private int stock;
}