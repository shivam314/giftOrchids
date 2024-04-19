package com.giftOrchids.giftOrchids.repository;

import com.giftOrchids.giftOrchids.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
