/**
 * 
 */
package com.soft.library.dataBase.service;

import java.util.Set;

import javax.persistence.EntityManager;

import com.soft.library.dataBase.dao.AuthorDAO;
import com.soft.library.dataBase.dao.BookDAO;
import com.soft.library.dataBase.dao.impl.AuthorDAOImpl;
import com.soft.library.dataBase.dao.impl.BookDAOImpl;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.Author;

/**
 * @author rd
 *
 */
public class AuthorService {
    public void addAuthor(String title, Set<String> books) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDAO authorDAO = new AuthorDAOImpl(entityManager);
        BookDAO bookDAO = new BookDAOImpl(entityManager);
        Author author = new Author();
        author.setName(title);
        Contributors con = new Contributors();
        author.setBooks(con.getBook(books, bookDAO));
        author = authorDAO.saveEntity(author);
        
        // close
        entityManager.getTransaction().commit();
    }

    public int updateAuthors(String oldName, String newName) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDAO authorDAO = new AuthorDAOImpl(entityManager);

        int count = 0;
        for (Author a : authorDAO.getAll()) {
            if (a.getName().equals(oldName)) {
                a.setName(newName);
                a = authorDAO.saveEntity(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public void printAuthors() {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDAO authorDAO = new AuthorDAOImpl(entityManager);

        System.out.println("\nAll Authors:");
        for (Author a : authorDAO.getAll()) {
            System.out.println("authorDAO: id=" + a.getId() + " Title="
                    + a.getName());
        }

        // close
        entityManager.getTransaction().commit();
    }

    public Author getAuthorById(int authorDAOId) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDAO authorDAO = new AuthorDAOImpl(entityManager);

        Author author = authorDAO.findById(authorDAOId);

        // close
        entityManager.getTransaction().commit();

        return author;
    }

    public void deleteAuthor(String name) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDAO authorDAO = new AuthorDAOImpl(entityManager);

        for (Author a : authorDAO.getAll()) {
            if (a.getName().equalsIgnoreCase(name)) {
                authorDAO.remove(a);
                break;
            }
        }

        // close
        entityManager.getTransaction().commit();
    }
}
