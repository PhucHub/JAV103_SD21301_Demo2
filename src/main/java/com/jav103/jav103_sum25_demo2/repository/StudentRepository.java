package com.jav103.jav103_sum25_demo2.repository;

import com.jav103.jav103_sum25_demo2.entity.Student;
import com.jav103.jav103_sum25_demo2.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepository {


    public List<Student> getStudents() {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
          return em.createQuery("select s from Student s", Student.class).getResultList();
        }
    }

    public Student getStudentById(Long id) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.find(Student.class, id);

        }catch (Exception e) {
        e.printStackTrace();
        return null;
        }
    }

    public void deleteStudent(Long id) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
            }
            em.getTransaction().commit();
        }
    }

    public void addStudent(Student student) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }

    }

    public void editStudent(Student student) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }
    }
}
