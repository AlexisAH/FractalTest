package com.example.Fractal.Controller;

import com.example.Fractal.Document.Product;
import com.example.Fractal.Service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<List<Product>>(productService.allProducts(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Product>>(productService.getProductById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.OK);
    }
}
