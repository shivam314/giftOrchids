package com.giftOrchids.giftOrchids.controller;

import com.giftOrchids.giftOrchids.models.Category;
import com.giftOrchids.giftOrchids.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public Optional<Category> getCategory(@RequestParam Integer cid) {
        return categoryService.getCategory(cid);
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/addCategory")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

}
