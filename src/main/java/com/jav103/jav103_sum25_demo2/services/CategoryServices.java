package com.jav103.jav103_sum25_demo2.services;

import com.jav103.jav103_sum25_demo2.entity.Category;
import com.jav103.jav103_sum25_demo2.repository.CategoryRepository;

import java.util.List;

public class CategoryServices {
    private CategoryRepository repository = new CategoryRepository();

    public List<Category> getCategories() {
        return repository.getCategories();
    }

    public Category getCategoryById(Long id) {
        return repository.getCategoryById(id);
    }
}
