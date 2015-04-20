/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.LibraryDao;
import com.soft.library.dataBase.model.Library;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */
public class LibraryDaoShared extends BaseDaoShared<Library> implements LibraryDao {

    public LibraryDaoShared(EntityManager entityManager) {
        super(Library.class, entityManager);
    }
}
