package com.giftOrchids.giftOrchids.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giftOrchids.giftOrchids.models.Product;
import com.giftOrchids.giftOrchids.service.ProductService;
import com.giftOrchids.giftOrchids.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gift-orchids")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    public S3Service s3Service;

    @GetMapping("/product")
    public Optional<Product> getProduct(@RequestParam("pid") Integer pid) {
        return productService.getProduct(pid);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping(value = "/addProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addProducts(
      @RequestParam("product") String productJson,
      @RequestParam("file") MultipartFile file
    ) {
        try {
            // Deserialize JSON string to Product object
            ObjectMapper objectMapper = new ObjectMapper();
            Product product = objectMapper.readValue(productJson, Product.class);

            String fileName = s3Service.uploadFile(file);
            String url = s3Service.getFileUrl(fileName).toString();
            productService.addProduct(product, url);
            return ResponseEntity.ok("Successfully Added data!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }

}
