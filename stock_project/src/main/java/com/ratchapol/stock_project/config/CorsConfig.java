package com.ratchapol.stock_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**"); // not specific domain
        registry.addMapping("/product/*")
                .allowedMethods("*") // to allow all HTTP method
                .allowedOrigins("", "");
        
        
//         registry.addMapping("/product/*").allowedMethods("*");
//         registry.addMapping("/product").allowedMethods("GET", "POST");
        
        
    }
}