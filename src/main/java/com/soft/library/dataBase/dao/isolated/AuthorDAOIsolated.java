/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.AuthorDao;
import com.soft.library.dataBase.model.Author;

/**
 * Class for the Author entity dao methods.
 * All methods of this class are isolated, each of them runs in it's own transaction.
 * It's impossible to call a method of this class with a method of any other dao class in a single shared transaction.
 */
public class AuthorDaoIsolated extends BaseDaoIsolated<Author> implements AuthorDao {
    public AuthorDaoIsolated() {
        super(Author.class);
    }
}