/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.LibraryLogEntryDao;
import com.soft.library.dataBase.model.LibraryLogEntry;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */
public class LibraryLogEntryDaoShared extends BaseDaoShared<LibraryLogEntry> implements LibraryLogEntryDao {

    public LibraryLogEntryDaoShared(EntityManager entityManager) {
        super(LibraryLogEntry.class, entityManager);
    }
}
