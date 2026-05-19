package com.demo.jav103_sum25_demo1.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtils {
//emf day ma
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");

    public static EntityManager getEntityManager() {

        return emf.createEntityManager();
    }
}

// Cais emf owr ddaau nhir
// Chayj terminal chir owr mays e thooi af? may a ko hien
//a chay lai xem nao
// ok leen roi