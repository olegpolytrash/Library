/**
 * 
 */
package com.soft.library.dataBase.service;

import javax.persistence.EntityManager;

import com.soft.library.dataBase.dao.PublisherDAO;
import com.soft.library.dataBase.dao.impl.PublisherDAOImpl;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.Publisher;

/**
 * @publisher rd
 *
 */
public class AdvPublisherService {
    public void addPublisher(String name) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        PublisherDAO publisherDAO = new PublisherDAOImpl(entityManager);
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisherDAO.save(publisher);
        
        // close
        entityManager.getTransaction().commit();
    }

    public int updatePublishers(String oldName, String newName) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        PublisherDAO publisherDAO = new PublisherDAOImpl(entityManager);

        int count = 0;
        for (Publisher a : publisherDAO.getAll()) {
            if (a.getName().equals(oldName)) {
                a.setName(newName);
                a = publisherDAO.getUpdatedEntity(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public void printPublishers() {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        PublisherDAO publisherDAO = new PublisherDAOImpl(entityManager);

        System.out.println("\nAll Publishers:");
        for (Publisher a : publisherDAO.getAll()) {
            System.out.println("publisherDAO: id=" + a.getId() + " Title="
                    + a.getName());
        }

        // close
        entityManager.getTransaction().commit();
    }

    public Publisher getPublisherById(int publisherDAOId) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        PublisherDAO publisherDAO = new PublisherDAOImpl(entityManager);

        Publisher publisher = publisherDAO.findById(publisherDAOId);

        // close
        entityManager.getTransaction().commit();

        return publisher;
    }

    public void deletePublisher(String name) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        PublisherDAO publisherDAO = new PublisherDAOImpl(entityManager);

        for (Publisher a : publisherDAO.getAll()) {
            if (a.getName().equalsIgnoreCase(name)) {
                publisherDAO.remove(a);
                break;
            }
        }

        // close
        entityManager.getTransaction().commit();
    }
}
