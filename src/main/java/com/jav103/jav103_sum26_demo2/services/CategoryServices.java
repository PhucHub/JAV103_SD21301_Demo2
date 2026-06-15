package com.jav103.jav103_sum26_demo2.services;

import com.jav103.jav103_sum26_demo2.entity.Category;
import com.jav103.jav103_sum26_demo2.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoryServices {

    public List<Category> getCategories() {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.createQuery("select c from Category c", Category.class).getResultList();
        }
    }
}
