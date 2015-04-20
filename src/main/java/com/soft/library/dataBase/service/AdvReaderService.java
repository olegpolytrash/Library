package com.soft.library.dataBase.service;

import java.sql.Date;
import java.util.Set;

import javax.persistence.EntityManager;

import com.soft.library.dataBase.dao.ReaderDAO;
import com.soft.library.dataBase.dao.BookDAO;
import com.soft.library.dataBase.dao.impl.ReaderDAOImpl;
import com.soft.library.dataBase.dao.impl.BookDAOImpl;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.Reader;

public class AdvReaderService {
    public void addReader(String name, String surname, String mobilePhone,
            String address, Date birthDate) {
        
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDAO readerDAO = new ReaderDAOImpl(entityManager);
        Reader reader = new Reader(name, surname, mobilePhone, address,
                birthDate);
        reader = readerDAO.saveEntity(reader);

        // close
        entityManager.getTransaction().commit();
    }

    public int updateReaderBDate(String oldBDate, String newBDate) {
        
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();
        
        // initialize DAO
        ReaderDAO readerDAO = new ReaderDAOImpl(entityManager);
        
        int count = 0;
        for (Reader a : readerDAO.getAll()) {
            if (a.getBirthDate().equals(Date.valueOf(oldBDate))) {
                a.setBirthDate(Date.valueOf(newBDate));
                a = readerDAO.saveEntity(a);
                count++;
            }
        }
        
        // close
        entityManager.getTransaction().commit();
        
        return count;
    }
    public int updateReaderName(String oldFirstName, String newFirstName,
            String oldSecName, String newSecName) {
        
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDAO readerDAO = new ReaderDAOImpl(entityManager);

        int count = 0;
        for (Reader a : readerDAO.getAll()) {
            if (a.getName().equals(oldFirstName)
                    && a.getSurname().equals(oldSecName)) {
                a.setName(newFirstName);
                a.setSurname(newSecName);
                a = readerDAO.saveEntity(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public int updateReaderMobile(String oldMobile, String newMobile) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDAO readerDAO = new ReaderDAOImpl(entityManager);

        int count = 0;
        for (Reader a : readerDAO.getAll()) {
            if (a.getMobilePhone().equals(oldMobile)) {
                a.setMobilePhone(newMobile);
                a = readerDAO.saveEntity(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public int updateReaderAddress(String oldAddress, String newAddress) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDAO readerDAO = new ReaderDAOImpl(entityManager);

        int count = 0;
        for (Reader a : readerDAO.getAll()) {
            if (a.getAddress().equals(oldAddress)) {
                a.setAddress(newAddress);
                a = readerDAO.saveEntity(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public void printReaders() {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDAO readerDAO = new ReaderDAOImpl(entityManager);

        System.out.println("\nAll Readers:");
        for (Reader a : readerDAO.getAll()) {
            System.out.println("readerDAO: id=" + a.getId() + " Title="
                    + a.getName());
        }

        // close
        entityManager.getTransaction().commit();
    }

    public Reader getReaderById(int readerDAOId) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDAO readerDAO = new ReaderDAOImpl(entityManager);

        Reader reader = readerDAO.findById(readerDAOId);

        // close
        entityManager.getTransaction().commit();

        return reader;
    }

    public void deleteReader(String name) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDAO readerDAO = new ReaderDAOImpl(entityManager);

        for (Reader a : readerDAO.getAll()) {
            if (a.getName().equalsIgnoreCase(name)) {
                readerDAO.remove(a);
                break;
            }
        }

        // close
        entityManager.getTransaction().commit();
    }
}
