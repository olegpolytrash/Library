/**
 * 
 */
package com.soft.library.dataBase.service;

import com.soft.library.dataBase.dao.AuthorDao;
import com.soft.library.dataBase.dao.BookDao;
import com.soft.library.dataBase.dao.shared.AuthorDaoShared;
import com.soft.library.dataBase.dao.shared.BookDaoShared;
import com.soft.library.dataBase.dataBaseCore.JpaUtil;
import com.soft.library.dataBase.model.Author;

import javax.persistence.EntityManager;
import java.util.Set;

/**
 * @author rd
 *
 */
public class AuthorService {
    public void addAuthor(String title, Set<String> books) {
        // prepare
        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDao authorDao = new AuthorDaoShared(entityManager);
        BookDao bookDao = new BookDaoShared(entityManager);
        Author author = new Author();
        author.setName(title);
        Contributors con = new Contributors();
        author.setBooks(con.getBook(books, bookDao));
        author = authorDao.saveEntity(author);
        
        // close
        entityManager.getTransaction().commit();
    }

    public int updateAuthors(String oldName, String newName) {
        // prepare
        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDao authorDao = new AuthorDaoShared(entityManager);

        int count = 0;
        for (Author a : authorDao.getAll()) {
            if (a.getName().equals(oldName)) {
                a.setName(newName);
                a = authorDao.saveEntity(a);
                count++;
            }
        }

        // close
        entityManager.getTransaction().commit();

        return count;
    }

    public void printAuthors() {
        // prepare
        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDao authorDao = new AuthorDaoShared(entityManager);

        System.out.println("\nAll Authors:");
        for (Author a : authorDao.getAll()) {
            System.out.println("authorDao: id=" + a.getId() + " Title="
                    + a.getName());
        }

        // close
        entityManager.getTransaction().commit();
    }

    public Author getAuthorById(int authorDAOId) {
        // prepare
        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDao authorDao = new AuthorDaoShared(entityManager);

        Author author = authorDao.findById(authorDAOId);

        // close
        entityManager.getTransaction().commit();

        return author;
    }

    public void deleteAuthor(String name) {
        // prepare
        EntityManager entityManager = JpaUtil.getEntityManagerFactory()
                .createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDao authorDao = new AuthorDaoShared(entityManager);

        for (Author a : authorDao.getAll()) {
            if (a.getName().equalsIgnoreCase(name)) {
                authorDao.remove(a);
                break;
            }
        }

        // close
        entityManager.getTransaction().commit();
    }
}
