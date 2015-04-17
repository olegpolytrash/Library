package com.soft.library.dataBase.dataBaseCore;

import javax.persistence.*;

public class JPAUtil {

    private static final EntityManagerFactory emf = buildEntityManagerFactor();


    private static EntityManagerFactory buildEntityManagerFactor() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return Persistence.createEntityManagerFactory("JPAService");

        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getEntityManagerFactory().close();
    }

    //EntityManager em = emf.createEntityManager();
}