/**
 * 
 */
package com.soft.library.dataBase.service;

import com.soft.library.dataBase.dao.PublisherDao;
import com.soft.library.dataBase.dao.shared.PublisherDaoShared;
import com.soft.library.dataBase.dataBaseCore.JpaUtil;
import com.soft.library.dataBase.model.Publisher;

import javax.persistence.EntityManager;

/**
 * @publisher rd
 *
 */
public class PublisherService {
    public void addPublisher(String name) {
        // prepare
        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        PublisherDao publisherDao = new PublisherDaoShared(entityManager);
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher = publisherDao.saveEntity(publisher);
        
        // close
        entityManager.getTransaction().commit();
    }

    public int updatePublishers(String oldName, String newName) {
        // prepare
        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        PublisherDao publisherDao = new PublisherDaoShared(entityManager);

        int count = 0;
        for (Publisher a : publisherDao.getAll()) {
            if (a.getName().equals(oldName)) {
                a.setName(newName);
                a = publisherDao.saveEntity(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public void printPublishers() {
        // prepare
        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        PublisherDao publisherDao = new PublisherDaoShared(entityManager);

        System.out.println("\nAll Publishers:");
        for (Publisher a : publisherDao.getAll()) {
            System.out.println("publisherDao: id=" + a.getId() + " Title="
                    + a.getName());
        }

        // close
        entityManager.getTransaction().commit();
    }

    public Publisher getPublisherById(int publisherDAOId) {
        // prepare
        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        PublisherDao publisherDao = new PublisherDaoShared(entityManager);

        Publisher publisher = publisherDao.findById(publisherDAOId);

        // close
        entityManager.getTransaction().commit();

        return publisher;
    }

    public void deletePublisher(String name) {
        // prepare
        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        PublisherDao publisherDao = new PublisherDaoShared(entityManager);

        for (Publisher a : publisherDao.getAll()) {
            if (a.getName().equalsIgnoreCase(name)) {
                publisherDao.remove(a);
                break;
            }
        }

        // close
        entityManager.getTransaction().commit();
    }
}
