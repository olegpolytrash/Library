/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.BookDao;
import com.soft.library.dataBase.model.Book;

import javax.persistence.EntityManager;

/**
 * Class for the Book entity dao methods.
 * All methods of this class can be used in a shared transaction with other methods.
 */
public class BookDaoShared extends BaseDaoShared<Book> implements BookDao {

    public BookDaoShared(EntityManager entityManager) {
        super(Book.class, entityManager);
    }
}
