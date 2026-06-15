package com.jav103.jav103_sum26_demo2.repository;

import com.jav103.jav103_sum26_demo2.entity.Product;
import com.jav103.jav103_sum26_demo2.entity.Student;
import com.jav103.jav103_sum26_demo2.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductRepository {

    public List<Product> getAllProduct() {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.createQuery("select p from Product p", Product.class).getResultList();
        }
    }

    public void deleteProduct(Long id) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            Product product = em.find(Product.class, id);
            if (product != null) {
                em.remove(product);
            }
            em.getTransaction().commit();
        }
    }

    public Product getProductById(Long id) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.find(Product.class, id);

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addProduct(Product product) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        }

    }

    public void editProduct(Product product) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
        }
    }
}
