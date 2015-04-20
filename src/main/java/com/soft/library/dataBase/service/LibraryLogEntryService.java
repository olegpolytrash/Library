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
//import com.soft.library.dataBase.dao.LibraryLogEntryDaoIsolated;
//import com.soft.library.dataBase.dao.BookDaoIsolated;
//import com.soft.library.dataBase.dao.ReaderDaoIsolated;
//import com.soft.library.dataBase.dao.shared.LibraryLogEntryDaoShared;
//import com.soft.library.dataBase.dao.shared.BookDaoShared;
//import com.soft.library.dataBase.dao.shared.ReaderDaoShared;
//import com.soft.library.dataBase.dataBaseCore.JpaUtil;
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
//        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
//                .createEntityManager();
//        entityManager.getTransaction().begin();
//
//        // initialize DAO
//        LibraryLogEntryDaoIsolated libraryLogEntryDAO = new LibraryLogEntryDaoShared(entityManager);
//        BookDaoIsolated bookDAO = new BookDaoShared(entityManager);
//        ReaderDaoIsolated readerDAO = new ReaderDaoShared(entityManager);
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
//        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
//                .createEntityManager();
//        entityManager.getTransaction().begin();
//
//        // initialize DAO
//        LibraryLogEntryDaoIsolated libraryLogEntryDAO = new LibraryLogEntryDaoShared(entityManager);
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
//        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
//                .createEntityManager();
//        entityManager.getTransaction().begin();
//
//        // initialize DAO
//        LibraryLogEntryDaoIsolated libraryLogEntryDAO = new LibraryLogEntryDaoShared(entityManager);
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
//        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
//                .createEntityManager();
//        entityManager.getTransaction().begin();
//
//        // initialize DAO
//        LibraryLogEntryDaoIsolated libraryLogEntryDAO = new LibraryLogEntryDaoShared(entityManager);
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
//        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
//                .createEntityManager();
//        entityManager.getTransaction().begin();
//
//        // initialize DAO
//        LibraryLogEntryDaoIsolated libraryLogEntryDAO = new LibraryLogEntryDaoShared(entityManager);
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
