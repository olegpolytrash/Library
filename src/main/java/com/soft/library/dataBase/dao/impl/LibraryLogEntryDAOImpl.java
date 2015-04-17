/**
 * 
 */
package com.soft.library.dataBase.dao.impl;

import com.soft.library.dataBase.model.LibraryLogEntry;
import com.soft.library.dataBase.dao.LibraryLogEntryDAO;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */
public class LibraryLogEntryDAOImpl extends ElementDAOImpl<LibraryLogEntry> implements LibraryLogEntryDAO {

    public LibraryLogEntryDAOImpl(EntityManager entityManager) {
        super(LibraryLogEntry.class, entityManager);
    }
}
