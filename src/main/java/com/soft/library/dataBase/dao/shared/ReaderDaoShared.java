/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.ReaderDao;
import com.soft.library.dataBase.model.Reader;

import javax.persistence.EntityManager;

/**
 * Class for the Reader entity dao methods.
 * All methods of this class can be used in a shared transaction with other methods.
 */
public class ReaderDaoShared extends BaseDaoShared<Reader> implements ReaderDao {

    public ReaderDaoShared(EntityManager entityManager) {
        super(Reader.class, entityManager);
    }
}
