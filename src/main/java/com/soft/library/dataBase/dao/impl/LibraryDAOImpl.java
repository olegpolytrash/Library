/**
 * 
 */
package com.soft.library.dataBase.dao.impl;

import com.soft.library.dataBase.model.Library;
import com.soft.library.dataBase.dao.LibraryDAO;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */
public class LibraryDAOImpl extends ElementDAOImpl<Library> implements LibraryDAO {

    public LibraryDAOImpl(EntityManager entityManager) {
        super(Library.class, entityManager);
    }
}
