package com.jav103.jav103_sum25_demo2.repository;

import com.jav103.jav103_sum25_demo2.entity.Department;
import com.jav103.jav103_sum25_demo2.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

    public void addDepartment(Department department) {
        EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void updateDepartment(Department department) {
        EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleteDepartment(Long id) {
        EntityManager em = EntityManagerUtils.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Department department = em.find(Department.class, id);
            if (department != null) {
                em.remove(department);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Department> searchByName(String keyword) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.createQuery("select d from Department d where d.name like :keyword", Department.class)
                    .setParameter("keyword", "%" + keyword + "%")
                    .getResultList();
        }
    }
}
