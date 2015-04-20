/**
 * 
 */
package com.soft.library.dataBase.dao.oneOp;

import com.soft.library.dataBase.model.Book;

/**
 * @author rd
 *
 */
public class BookDAO extends ElementDAO<Book> implements com.soft.library.dataBase.dao.BookDAO {

    public BookDAO() {
        super(Book.class);
    }
}
