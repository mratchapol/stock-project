package com.ratchapol.stock_project;

import com.ratchapol.stock_project.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockProjectApplication.class, args);
      }
    
    @Bean
    CommandLineRunner init(StorageService storageService){
        return args -> {
            storageService.init();
        };
    }

}