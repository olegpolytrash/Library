/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.ReaderDao;
import com.soft.library.dataBase.model.Reader;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */
public class ReaderDaoShared extends BaseDaoShared<Reader> implements ReaderDao {

    public ReaderDaoShared(EntityManager entityManager) {
        super(Reader.class, entityManager);
    }
}
