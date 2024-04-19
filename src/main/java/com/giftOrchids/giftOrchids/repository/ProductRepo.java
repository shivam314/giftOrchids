package com.giftOrchids.giftOrchids.repository;

import com.giftOrchids.giftOrchids.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
