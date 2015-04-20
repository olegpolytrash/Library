/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.LibraryLogEntryDao;
import com.soft.library.dataBase.model.LibraryLogEntry;

/**
 * @author rd
 *
 */
public class LibraryLogEntryDaoIsolated extends BaseDaoIsolated<LibraryLogEntry> implements LibraryLogEntryDao {

    public LibraryLogEntryDaoIsolated() {
        super(LibraryLogEntry.class);
    }
}
