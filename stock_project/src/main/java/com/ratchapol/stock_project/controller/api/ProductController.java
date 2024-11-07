package com.ratchapol.stock_project.controller.api;


import com.ratchapol.stock_project.exception.ProductNotFoundException;
import com.ratchapol.stock_project.model.Product;
import com.ratchapol.stock_project.service.StorageService;
import com.ratchapol.stock_project.controller.request.ProductRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({})
public class ProductController {
    
    private final AtomicLong counter = new AtomicLong();
    private List<Product> products = new ArrayList<>();
    private StorageService storageService;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class); // To store logs related to ProductController class
    
    ProductController(StorageService storageService){
        this.storageService = storageService;
    }
    
    @GetMapping("product")
    public List<Product> getProducts(){
        log.error("This is error");
        log.warn("This is warning");
        return products;
    }
    
    @GetMapping(path = "/product/{id}")
    public Product getProduct(@PathVariable int id){
        return products.stream().filter(result -> result.getId() == id).findFirst().orElseThrow(
                () -> new ProductNotFoundException(id)
        );
    }
    @GetMapping({"/product/{id}/name/{name}", "/productname/{id}"})
    public String getProductByName(@PathVariable(value="id") int id, @PathVariable(required=false) String name){
        return "Product " + name + " id: " + id;
    }
    @GetMapping("/product/print")
    public String getProductNameQuery(@RequestParam(name="name", required=false, defaultValue="Sponge") String name){
        return "Product " + name;
    }
    
    
   // POST method
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/product")
    public Product addProduct(ProductRequest productRequest){
        // @RequestBody does mapping between model and JSON
        // get param and return as JSON
        String fileName = storageService.store(productRequest.getImage());
        
        Product data = new Product(counter.incrementAndGet(), productRequest.getName(), fileName, productRequest.getPrice(), productRequest.getStock());
        products.add(data);
        return data;
    }
    
    // PUT method
    
    @PutMapping("/product/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable int id){
        Product data;
        products.stream().filter(result -> result.getId() == id).findFirst()
                .ifPresentOrElse(result -> {
                    result.setName(product.getName());
                    result.setImage(product.getImage());
                    result.setPrice(product.getPrice());
                    result.setStock(product.getStock());
                }, () -> {
                    throw new ProductNotFoundException(id);
                });
    }
    
    // DELETE method
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id){
        // ถ้าพบ id ที่มองหาใน List ให้ลบ item นั้น
        products.stream().filter(result -> result.getId() == id).findFirst().ifPresentOrElse(result -> {
            products.remove(result);
        }, () -> {
            throw new ProductNotFoundException(id);
        });
    }
    
    // Handle exception by controller, or better to move to ExceptionAdvice
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    String handlerProductNotFoundException(ProductNotFoundException exception){
//        return exception.getMessage();
//    }
}