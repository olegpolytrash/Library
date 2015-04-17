/**
 * 
 */
package com.soft.library.dataBase.dao.impl;

import com.soft.library.dataBase.model.Reader;
import com.soft.library.dataBase.dao.ReaderDAO;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */
public class ReaderDAOImpl extends ElementDAOImpl<Reader> implements ReaderDAO {

    public ReaderDAOImpl(EntityManager entityManager) {
        super(Reader.class, entityManager);
    }
}
