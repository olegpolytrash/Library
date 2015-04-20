/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.BookDao;
import com.soft.library.dataBase.model.Book;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */
public class BookDaoShared extends BaseDaoShared<Book> implements BookDao {

    public BookDaoShared(EntityManager entityManager) {
        super(Book.class, entityManager);
    }
}
