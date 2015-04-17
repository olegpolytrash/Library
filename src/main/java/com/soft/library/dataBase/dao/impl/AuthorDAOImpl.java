/**
 * 
 */
package com.soft.library.dataBase.dao.impl;

import com.soft.library.dataBase.model.Author;
import com.soft.library.dataBase.dao.AuthorDAO;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */

public class AuthorDAOImpl extends ElementDAOImpl<Author> implements AuthorDAO {

    public AuthorDAOImpl(EntityManager entityManager) {
        super(Author.class, entityManager);
    }


}
