/**
 * 
 */
package com.soft.library.dataBase.dao.impl;

import com.soft.library.dataBase.model.Book;
import com.soft.library.dataBase.dao.BookDAO;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */
public class BookDAOImpl extends ElementDAOImpl<Book> implements BookDAO {

    public BookDAOImpl(EntityManager entityManager) {
        super(Book.class, entityManager);
    }
}
