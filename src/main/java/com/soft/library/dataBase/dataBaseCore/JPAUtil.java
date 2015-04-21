package com.soft.library.dataBase.dataBaseCore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class for jpa management functions.
 */
public enum JpaUtil {
    ENTITY_MANAGER_FACTORY;

    private final EntityManagerFactory emf = buildEntityManagerFactor();

    private EntityManagerFactory buildEntityManagerFactor() {
            return Persistence.createEntityManagerFactory("JPAService");
    }

    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}