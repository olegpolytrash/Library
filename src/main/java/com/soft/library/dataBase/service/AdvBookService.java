package com.soft.library.dataBase.service;

import java.util.Set;

import javax.persistence.EntityManager;

import com.soft.library.dataBase.dao.AuthorDAO;
import com.soft.library.dataBase.dao.BookDAO;
import com.soft.library.dataBase.dao.impl.AuthorDAOImpl;
import com.soft.library.dataBase.dao.impl.BookDAOImpl;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.Book;


public class AdvBookService {
    public void addBook(String title, Set<String> authors) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        BookDAO bookDAO = new BookDAOImpl(entityManager);
        AuthorDAO authorDAO = new AuthorDAOImpl(entityManager);
        Book book = new Book();
        book.setName(title);
        Contributors con = new Contributors();
        book.setAuthors(con.getAuthor(authors, authorDAO));
        bookDAO.save(book);
        
        // close
        entityManager.getTransaction().commit();
    }

    public int updateBooks(String oldName, String newName) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        BookDAO bookDAO = new BookDAOImpl(entityManager);

        int count = 0;
        for (Book a : bookDAO.getAll()) {
            if (a.getName().equals(oldName)) {
                a.setName(newName);
                a = bookDAO.getUpdatedEntity(a);
                bookDAO.save(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public void printBooks() {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        BookDAO bookDAO = new BookDAOImpl(entityManager);

        System.out.println("\nAll Books:");
        for (Book a : bookDAO.getAll()) {
            System.out.println("bookDAO: id=" + a.getId() + " Title="
                    + a.getName());
        }

        // close
        entityManager.getTransaction().commit();
    }

    public Book getBookById(int bookDAOId) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        BookDAO bookDAO = new BookDAOImpl(entityManager);

        Book book = bookDAO.findById(bookDAOId);

        // close
        entityManager.getTransaction().commit();

        return book;
    }

    public void deleteBook(String name) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        BookDAO bookDAO = new BookDAOImpl(entityManager);

        for (Book a : bookDAO.getAll()) {
            if (a.getName().equalsIgnoreCase(name)) {
                bookDAO.remove(a);
                break;
            }
        }

        // close
        entityManager.getTransaction().commit();
    }
}