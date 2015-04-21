/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.BookDao;
import com.soft.library.dataBase.model.Book;

/**
 * Class for the Book entity dao methods.
 * All methods of this class are isolated, each of them runs in it's own transaction.
 * It's impossible to call a method of this class with a method of any other dao class in a single shared transaction.
 */
public class BookDaoIsolated extends BaseDaoIsolated<Book> implements BookDao {
    public BookDaoIsolated() {
        super(Book.class);
    }
}
