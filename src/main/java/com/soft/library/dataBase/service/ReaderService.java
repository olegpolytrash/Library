package com.soft.library.dataBase.service;

import com.soft.library.dataBase.dao.ReaderDao;
import com.soft.library.dataBase.dao.shared.ReaderDaoShared;
import com.soft.library.dataBase.dataBaseCore.JpaUtil;
import com.soft.library.dataBase.model.Reader;

import javax.persistence.EntityManager;
import java.sql.Date;

public class ReaderService {
    public void addReader(String name, String surname, String mobilePhone,
            String address, Date birthDate) {
        
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDao readerDao = new ReaderDaoShared(entityManager);
        Reader reader = new Reader(name, surname, mobilePhone, address,
                birthDate);
        reader = readerDao.saveEntity(reader);

        // close
        entityManager.getTransaction().commit();
    }

    public int updateReaderBDate(String oldBDate, String newBDate) {
        
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();
        
        // initialize DAO
        ReaderDao readerDao = new ReaderDaoShared(entityManager);
        
        int count = 0;
        for (Reader a : readerDao.getAll()) {
            if (a.getBirthDate().equals(Date.valueOf(oldBDate))) {
                a.setBirthDate(Date.valueOf(newBDate));
                a = readerDao.saveEntity(a);
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
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDao readerDao = new ReaderDaoShared(entityManager);

        int count = 0;
        for (Reader a : readerDao.getAll()) {
            if (a.getName().equals(oldFirstName)
                    && a.getSurname().equals(oldSecName)) {
                a.setName(newFirstName);
                a.setSurname(newSecName);
                a = readerDao.saveEntity(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public int updateReaderMobile(String oldMobile, String newMobile) {
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDao readerDao = new ReaderDaoShared(entityManager);

        int count = 0;
        for (Reader a : readerDao.getAll()) {
            if (a.getMobilePhone().equals(oldMobile)) {
                a.setMobilePhone(newMobile);
                a = readerDao.saveEntity(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public int updateReaderAddress(String oldAddress, String newAddress) {
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDao readerDao = new ReaderDaoShared(entityManager);

        int count = 0;
        for (Reader a : readerDao.getAll()) {
            if (a.getAddress().equals(oldAddress)) {
                a.setAddress(newAddress);
                a = readerDao.saveEntity(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public void printReaders() {
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDao readerDao = new ReaderDaoShared(entityManager);

        System.out.println("\nAll Readers:");
        for (Reader a : readerDao.getAll()) {
            System.out.println("readerDao: id=" + a.getId() + " Title="
                    + a.getName());
        }

        // close
        entityManager.getTransaction().commit();
    }

    public Reader getReaderById(int readerDAOId) {
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDao readerDao = new ReaderDaoShared(entityManager);

        Reader reader = readerDao.findById(readerDAOId);

        // close
        entityManager.getTransaction().commit();

        return reader;
    }

    public void deleteReader(String name) {
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        ReaderDao readerDao = new ReaderDaoShared(entityManager);

        for (Reader a : readerDao.getAll()) {
            if (a.getName().equalsIgnoreCase(name)) {
                readerDao.remove(a);
                break;
            }
        }

        // close
        entityManager.getTransaction().commit();
    }
}
