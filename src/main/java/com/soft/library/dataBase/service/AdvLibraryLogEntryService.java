package com.soft.library.dataBase.service;
///**
// * 
// */
//package com.soft.library.dataBase.service;
//
//import java.sql.Date;
//import java.util.Set;
//
//import javax.persistence.EntityManager;
//
//import com.soft.library.dataBase.dao.LibraryLogEntryDAO;
//import com.soft.library.dataBase.dao.BookDAO;
//import com.soft.library.dataBase.dao.ReaderDAO;
//import com.soft.library.dataBase.dao.impl.LibraryLogEntryDAOImpl;
//import com.soft.library.dataBase.dao.impl.BookDAOImpl;
//import com.soft.library.dataBase.dao.impl.ReaderDAOImpl;
//import com.soft.library.dataBase.dataBaseCore.JPAUtil;
//import com.soft.library.dataBase.model.Book;
//import com.soft.library.dataBase.model.LibraryLogEntry;
//import com.soft.library.dataBase.model.Reader;
//
///**
// * @libraryLogEntry rd
// *
// */
//public class AdvLibraryLogEntry {
//
//    public void addLibraryLogEntry(String book, String reader, Date taken, Date returned) {
//        // prepare
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
//                .createEntityManager();
//        entityManager.getTransaction().begin();
//
//        // initialize DAO
//        LibraryLogEntryDAO libraryLogEntryDAO = new LibraryLogEntryDAOImpl(entityManager);
//        BookDAO bookDAO = new BookDAOImpl(entityManager);
//        ReaderDAO readerDAO = new ReaderDAOImpl(entityManager);
//        LibraryLogEntry libraryLogEntry = new LibraryLogEntry();
//        Contributors con = new Contributors();
//        
////        libraryLogEntry.setBook(con.getBook(book, bookDAO));
////        libraryLogEntry.setReader(con.);
////        libraryLogEntryDAO.save(libraryLogEntry);
//        
//        // close
//        entityManager.getTransaction().commit();
//    }
//
//    public int updateLibraryLogEntrys(String oldName, String newName) {
//        // prepare
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
//                .createEntityManager();
//        entityManager.getTransaction().begin();
//
//        // initialize DAO
//        LibraryLogEntryDAO libraryLogEntryDAO = new LibraryLogEntryDAOImpl(entityManager);
//
//        int count = 0;
//        for (LibraryLogEntry a : libraryLogEntryDAO.getAll()) {
//            if (a.getName().equals(oldName)) {
//                a.setName(newName);
//                a = libraryLogEntryDAO.getUpdatedEntity(a);
//                count++;
//            }
//        }
//
//        // close
//        entityManager.getTransaction().commit();
//
//        return count;
//    }
//
//    public void printLibraryLogEntrys() {
//        // prepare
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
//                .createEntityManager();
//        entityManager.getTransaction().begin();
//
//        // initialize DAO
//        LibraryLogEntryDAO libraryLogEntryDAO = new LibraryLogEntryDAOImpl(entityManager);
//
//        System.out.println("\nAll LibraryLogEntrys:");
//        for (LibraryLogEntry a : libraryLogEntryDAO.getAll()) {
//            System.out.println("libraryLogEntryDAO: id=" + a.getId() + " Title="
//                    + a.getName());
//        }
//
//        // close
//        entityManager.getTransaction().commit();
//    }
//
//    public LibraryLogEntry getLibraryLogEntryById(int libraryLogEntryDAOId) {
//        // prepare
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
//                .createEntityManager();
//        entityManager.getTransaction().begin();
//
//        // initialize DAO
//        LibraryLogEntryDAO libraryLogEntryDAO = new LibraryLogEntryDAOImpl(entityManager);
//
//        LibraryLogEntry libraryLogEntry = libraryLogEntryDAO.findById(libraryLogEntryDAOId);
//
//        // close
//        entityManager.getTransaction().commit();
//
//        return libraryLogEntry;
//    }
//
//    public void deleteLibraryLogEntry(String name) {
//        // prepare
//        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
//                .createEntityManager();
//        entityManager.getTransaction().begin();
//
//        // initialize DAO
//        LibraryLogEntryDAO libraryLogEntryDAO = new LibraryLogEntryDAOImpl(entityManager);
//
//        for (LibraryLogEntry a : libraryLogEntryDAO.getAll()) {
//            if (a.getName().equalsIgnoreCase(name)) {
//                libraryLogEntryDAO.remove(a);
//                break;
//            }
//        }
//
//        // close
//        entityManager.getTransaction().commit();
//    }
//}
//
