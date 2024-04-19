package com.giftOrchids.giftOrchids.service;

import com.giftOrchids.giftOrchids.models.Category;
import com.giftOrchids.giftOrchids.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public Optional<Category> getCategory(Integer cid) {
        return categoryRepo.findById(cid);
    }

    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

}
