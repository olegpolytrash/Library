/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.AuthorDao;
import com.soft.library.dataBase.model.Author;

import javax.persistence.EntityManager;

/**
 * Class for the Author entity dao methods.
 * All methods of this class can be used in a shared transaction with other methods.
 */
public class AuthorDaoShared extends BaseDaoShared<Author> implements AuthorDao {
    public AuthorDaoShared(EntityManager entityManager) {
        super(Author.class, entityManager);
    }
}
