/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.LibraryDao;
import com.soft.library.dataBase.model.Library;

import javax.persistence.EntityManager;

/**
 * Class for the Library entity dao methods.
 * All methods of this class can be used in a shared transaction with other methods.
 */
public class LibraryDaoShared extends BaseDaoShared<Library> implements LibraryDao {

    public LibraryDaoShared(EntityManager entityManager) {
        super(Library.class, entityManager);
    }
}
