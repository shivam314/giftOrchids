package com.giftOrchids.giftOrchids.controller;

import com.giftOrchids.giftOrchids.models.Product;
import com.giftOrchids.giftOrchids.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public Optional<Product> getProduct(@RequestParam Integer pid) {
        return productService.getProduct(pid);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/addProduct")
    public void addProducts(@RequestBody Product product) {
        productService.addProduct(product);
    }

}
