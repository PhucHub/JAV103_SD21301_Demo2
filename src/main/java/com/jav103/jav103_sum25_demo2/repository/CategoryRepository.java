package com.jav103.jav103_sum25_demo2.repository;

import com.jav103.jav103_sum25_demo2.entity.Category;
import com.jav103.jav103_sum25_demo2.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoryRepository {
    public List<Category> getCategories() {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.createQuery("select c from Category c", Category.class).getResultList();
        }
    }

    public Category getCategoryById(Long id) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.find(Category.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
