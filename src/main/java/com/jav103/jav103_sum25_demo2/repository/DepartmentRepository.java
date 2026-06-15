package com.jav103.jav103_sum25_demo2.repository;

import com.jav103.jav103_sum25_demo2.entity.Department;
import com.jav103.jav103_sum25_demo2.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DepartmentRepository {

    public List<Department> getDepartments() {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.createQuery("select d from Department d", Department.class).getResultList();
        }
    }

    public Department getDepartmentById(Long id) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.find(Department.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
