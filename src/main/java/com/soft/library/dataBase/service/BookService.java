package com.soft.library.dataBase.service;

import com.soft.library.dataBase.dao.AuthorDao;
import com.soft.library.dataBase.dao.BookDao;
import com.soft.library.dataBase.dao.shared.AuthorDaoShared;
import com.soft.library.dataBase.dao.shared.BookDaoShared;
import com.soft.library.dataBase.dataBaseCore.JpaUtil;
import com.soft.library.dataBase.model.Book;

import javax.persistence.EntityManager;
import java.util.Set;


public class BookService {
    public void addBook(String title, Set<String> authors) {
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        BookDao bookDao = new BookDaoShared(entityManager);
        AuthorDao authorDao = new AuthorDaoShared(entityManager);
        Book book = new Book();
        book.setName(title);
        Contributors con = new Contributors();
        book.setAuthors(con.getAuthor(authors, authorDao));
        book = bookDao.saveEntity(book);
        
        // close
        entityManager.getTransaction().commit();
    }

    public int updateBooks(String oldName, String newName) {
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        BookDao bookDao = new BookDaoShared(entityManager);

        int count = 0;
        for (Book a : bookDao.getAll()) {
            if (a.getName().equals(oldName)) {
                a.setName(newName);
                a = bookDao.saveEntity(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public void printBooks() {
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        BookDao bookDao = new BookDaoShared(entityManager);

        System.out.println("\nAll Books:");
        for (Book a : bookDao.getAll()) {
            System.out.println("bookDao: id=" + a.getId() + " Title="
                    + a.getName());
        }

        // close
        entityManager.getTransaction().commit();
    }

    public Book getBookById(int bookDAOId) {
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        BookDao bookDao = new BookDaoShared(entityManager);

        Book book = bookDao.findById(bookDAOId);

        // close
        entityManager.getTransaction().commit();

        return book;
    }

    public void deleteBook(String name) {
        // prepare
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        BookDao bookDao = new BookDaoShared(entityManager);

        for (Book a : bookDao.getAll()) {
            if (a.getName().equalsIgnoreCase(name)) {
                bookDao.remove(a);
                break;
            }
        }

        // close
        entityManager.getTransaction().commit();
    }
}