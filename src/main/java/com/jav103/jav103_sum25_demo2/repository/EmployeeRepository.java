package com.jav103.jav103_sum25_demo2.repository;

import com.jav103.jav103_sum25_demo2.entity.Employee;
import com.jav103.jav103_sum25_demo2.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmployeeRepository {


    public List<Employee> getEmployees() {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
          return em.createQuery("select e from Employee e left join fetch e.department", Employee.class).getResultList();
        }
    }

    public List<Employee> searchByName(String name) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.createQuery("select e from Employee e left join fetch e.department where e.name like :name", Employee.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        }
    }

    public Employee getEmployeeById(Long id) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.createQuery("select e from Employee e left join fetch e.department where e.id = :id", Employee.class)
                    .setParameter("id", id)
                    .getSingleResult();

        }catch (Exception e) {
        e.printStackTrace();
        return null;
        }
    }

    public void deleteEmployee(Long id) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            Employee employee = em.find(Employee.class, id);
            if (employee != null) {
                em.remove(employee);
            }
            em.getTransaction().commit();
        }
    }

    public void addEmployee(Employee employee) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
        }

    }

    public void editEmployee(Employee employee) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(employee);
            em.getTransaction().commit();
        }
    }
}
