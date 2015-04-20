/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.LibraryLogEntryDao;
import com.soft.library.dataBase.model.LibraryLogEntry;

import javax.persistence.EntityManager;

/**
 * Class for the LibraryLogEntry entity dao methods.
 * All methods of this class can be used in a shared transaction with other methods.
 */
public class LibraryLogEntryDaoShared extends BaseDaoShared<LibraryLogEntry> implements LibraryLogEntryDao {

    public LibraryLogEntryDaoShared(EntityManager entityManager) {
        super(LibraryLogEntry.class, entityManager);
    }
}
