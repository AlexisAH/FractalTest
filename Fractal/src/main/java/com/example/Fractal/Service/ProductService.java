package com.example.Fractal.Service;

import com.example.Fractal.Document.Product;
import com.example.Fractal.Repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//database Access methods
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> allProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(ObjectId id) {
        return productRepository.findById(id);
    }
    public Product createProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }
}
