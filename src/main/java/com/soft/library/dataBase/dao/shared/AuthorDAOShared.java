/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.AuthorDao;
import com.soft.library.dataBase.model.Author;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */

public class AuthorDaoShared extends BaseDaoShared<Author> implements AuthorDao {

    public AuthorDaoShared(EntityManager entityManager) {
        super(Author.class, entityManager);
    }

}
