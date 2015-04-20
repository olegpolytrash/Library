/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.BookDao;
import com.soft.library.dataBase.model.Book;

/**
 * @author rd
 *
 */
public class BookDaoIsolated extends BaseDaoIsolated<Book> implements BookDao {

    public BookDaoIsolated() {
        super(Book.class);
    }
}
