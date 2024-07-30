package com.giftOrchids.giftOrchids.service;

import com.giftOrchids.giftOrchids.models.Product;
import com.giftOrchids.giftOrchids.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Optional<Product> getProduct(Integer pid) {
        return productRepo.findById(pid);
    }

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public void addProduct(Product product, String url) {
        product.setImage(url);
        productRepo.save(product);
    }

}
